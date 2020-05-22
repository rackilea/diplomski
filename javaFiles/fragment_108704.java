public class FindStories {

    public static void main(String[] args) throws Exception {

        String host = "https://rally1.rallydev.com";
        String username = "user@co.com";
        String password = "secret";
        String applicationName = "RESTExampleFindStories";

        RallyRestApi restApi = null;
            try {
            restApi = new RallyRestApi(
                    new URI(host),
                    username,
                    password);
            restApi.setApplicationName(applicationName); 

            QueryRequest storyRequest = new QueryRequest("Requirement");
            storyRequest.setFetch(new Fetch(new String[] {"Name", "FormattedID", "ScheduleState", "State", "PlanEstimate", "TaskRemainingTotal", "CreationDate"}));
            storyRequest.setLimit(1000);
            storyRequest.setScopedDown(false);
            storyRequest.setScopedUp(false);
            storyRequest.setQueryFilter((new QueryFilter("Project.Name", "=", "Demandware")).and(new QueryFilter("Release.Name", "=", "201311 IT Integrated Release")));
            QueryResponse storyQueryResponse = restApi.query(storyRequest);
            System.out.println("Successful: " + storyQueryResponse.wasSuccessful());
            System.out.println("Size: " + storyQueryResponse.getTotalResultCount());
            System.out.println("Results Size: " + storyQueryResponse.getResults().size());
            for (int i=0; i<storyQueryResponse.getResults().size();i++){
                JsonObject storyJsonObject = storyQueryResponse.getResults().get(i).getAsJsonObject();
                System.out.println("Name: " + storyJsonObject.get("Name") + " ScheduleState: " + storyJsonObject.get("ScheduleState") + " State: " + storyJsonObject.get("State") + " PlanEstimate: " + storyJsonObject.get("PlanEstimate") + " TaskRemainingTotal: " + storyJsonObject.get("TaskRemainingTotal"));
            }
        } finally {
            if (restApi != null) {
                restApi.close();
            }
        }
    }

}