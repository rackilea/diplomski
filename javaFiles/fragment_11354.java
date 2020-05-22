public class GetBuildData {

    public static void main(String[] args) throws Exception {

        String host = "https://rally1.rallydev.com";
        String apiKey = "_abc123"; 
        String applicationName = "NickM:GetBuildData";
        String workspaceRef = "/workspace/12345";
        String projectRef = "/project/1346";

        RallyRestApi restApi = null;
        try {
            String dateString = "2016-05-12";
            restApi = new RallyRestApi(new URI(host),apiKey);
            restApi.setApplicationName(applicationName);
            QueryRequest buildRequest = new QueryRequest("Build");
            buildRequest.setFetch(new Fetch("Status,Message,Start,Uri,Changesets"));
            buildRequest.setQueryFilter(new QueryFilter("CreationDate", ">", dateString));
            buildRequest.setWorkspace(workspaceRef);
            buildRequest.setProject(projectRef);
            QueryResponse buildResponse = restApi.query(buildRequest);
            for (int i=0; i<buildResponse.getTotalResultCount();i++){
                JsonObject buildObj = buildResponse.getResults().get(i).getAsJsonObject();
                System.out.println("Build Status: " + buildObj.get("Status") +
                        "\n Build Message: " + buildObj.get("Message") +
                        "\n Build Start:   " + buildObj.get("Start") +
                        "\n Build Uri:     " + buildObj.get("Uri"));
                JsonObject changesetsCollection = buildObj.get("Changesets").getAsJsonObject();
                QueryRequest changesetsRequest = new QueryRequest(changesetsCollection);
                changesetsRequest.setFetch(new Fetch("Artifacts","Changes", "Revision"));
                changesetsRequest.setLimit(1000);
                QueryResponse changesetsResponse = restApi.query(changesetsRequest);
                for (int j=0; j<changesetsResponse.getTotalResultCount();j++) {
                    JsonObject changesetObj = changesetsResponse.getResults().get(j).getAsJsonObject();
                    System.out.println("\nChangeset Revision: " + changesetObj.get("Revision"));
                    JsonObject artifactsCollection = changesetObj.get("Artifacts").getAsJsonObject();
                    QueryRequest artifactsRequest = new QueryRequest(artifactsCollection);
                    artifactsRequest.setFetch(new Fetch("FormattedID"));
                    QueryResponse artifactsResponse = restApi.query(artifactsRequest);
                    for (int k=0; k<artifactsResponse.getTotalResultCount();k++) {
                        JsonObject artifactObj = artifactsResponse.getResults().get(k).getAsJsonObject();
                        System.out.println("\nArtifact FormattedID: " + artifactObj.get("FormattedID"));
                    }
                    JsonObject changesCollection = changesetObj.get("Changes").getAsJsonObject();
                    QueryRequest changesRequest = new QueryRequest(changesCollection);
                    changesRequest.setWorkspace(workspaceRef);
                    changesRequest.setProject(projectRef);
                    changesRequest.setFetch(new Fetch("PathAndFilename"));
                    QueryResponse changesResponse = restApi.query(changesRequest);
                    for (int l=0; l<changesResponse.getTotalResultCount();l++) {
                        JsonObject changeObj = changesResponse.getResults().get(l).getAsJsonObject();
                        System.out.println("Change PathAndFilename: " + changeObj.get("PathAndFilename"));
                    }

                }
                System.out.println("--------------------------------");
            }
        } finally {
            if (restApi != null) {
                restApi.close();
            }
        }
    }
}