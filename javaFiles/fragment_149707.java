public class FindIterationsByReleaseDateAndStories {

    public static void main(String[] args) throws URISyntaxException, IOException {


        String host = "https://rally1.rallydev.com";
            String username = "user@co.com";
            String password = "secret";
            String projectRef = "/project/12352608219";
            String applicationName = "Find Iterations by Release Dates and Stories";

            RallyRestApi restApi = null;

        try {
                restApi = new RallyRestApi(
                        new URI(host),
                        username,
                        password);
                restApi.setApplicationName(applicationName); 

                System.out.println(restApi.getWsapiVersion()); 

                QueryRequest  releaseRequest = new QueryRequest("Release");
                releaseRequest.setFetch(new Fetch("ReleaseStartDate", "ReleaseDate"));
                releaseRequest.setScopedDown(false);
                releaseRequest.setScopedUp(false);
                releaseRequest.setProject(projectRef);
                releaseRequest.setQueryFilter(new QueryFilter("Name", "=", "r1"));

                QueryResponse releaseQueryResponse = restApi.query(releaseRequest);
                int numberOfReleasesInProject = releaseQueryResponse.getTotalResultCount();
                System.out.println(numberOfReleasesInProject);
                JsonObject releaseJsonObject = releaseQueryResponse.getResults().get(0).getAsJsonObject();
                System.out.println(releaseJsonObject.get("ReleaseStartDate"));
                System.out.println(releaseJsonObject.get("ReleaseDate"));

                String rsd = releaseJsonObject.get("ReleaseStartDate").getAsString();
                String rd = releaseJsonObject.get("ReleaseDate").getAsString();

                QueryRequest  iterationRequest = new QueryRequest("Iteration");
                iterationRequest.setFetch(new Fetch("Name","StartDate","EndDate"));
                iterationRequest.setScopedDown(false);
                iterationRequest.setScopedUp(false);
                iterationRequest.setProject(projectRef);
                iterationRequest.setQueryFilter(new QueryFilter("StartDate", ">=", rsd).and(new QueryFilter("EndDate", "<=", rd)));

                QueryResponse iterationQueryResponse = restApi.query(iterationRequest);
                int numberOfIteraitons = iterationQueryResponse.getTotalResultCount();
                System.out.println("numberOfIteraitons " + numberOfIteraitons);
                if(numberOfIteraitons >0){
                    for (int i=0;i<numberOfIteraitons;i++){
                        JsonObject iterationJsonObject = iterationQueryResponse.getResults().get(i).getAsJsonObject();
                        String iterationName = iterationJsonObject.get("Name").getAsString();
                        System.out.println("iteration: " + iterationName);
                        QueryRequest storyRequest = new QueryRequest("HierarchicalRequirement");
                        storyRequest.setProject(projectRef);
                        storyRequest.setFetch(new Fetch(new String[] {"Name", "FormattedID","ScheduleState"}));
                        storyRequest.setLimit(1000);
                        storyRequest.setScopedDown(false);
                        storyRequest.setScopedUp(false);
                        storyRequest.setQueryFilter(new QueryFilter("Iteration.Name", "=", iterationName));

                        QueryResponse storyQueryResponse = restApi.query(storyRequest);
                        System.out.println("Number of stories in " + iterationName + " :" + storyQueryResponse.getTotalResultCount());

                        for (int j=0; j<storyQueryResponse.getResults().size();j++){
                            JsonObject storyJsonObject = storyQueryResponse.getResults().get(j).getAsJsonObject();
                            System.out.println("Name: " + storyJsonObject.get("Name") + " FormattedID: " + storyJsonObject.get("FormattedID") + " ScheduleState: " + storyJsonObject.get("ScheduleState"));
                        }
                    }
                }       
        }
        finally{
            if (restApi != null) {
                restApi.close();
            }
        }

    }
}