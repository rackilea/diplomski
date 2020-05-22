public static void main(String[] args) throws URISyntaxException, IOException {

    // Create and configure a new instance of RallyRestApi

    String host = "https://rally1.rallydev.com";
    String username = "user@domain.com";
    String password = "secret";
    String wsapiVersion = "v2.0";
        String workspaceRef = "/workspace/1111";
    String projectRef = "/project/2222"; 
    String applicationName = "DirectChildrenCount";


        RallyRestApi restApi = new RallyRestApi(
                new URI(host),
                username,
                password);
        restApi.setWsapiVersion(wsapiVersion);
        restApi.setApplicationName(applicationName);   


        QueryRequest storyRequest = new QueryRequest("HierarchicalRequirement");
        storyRequest.setFetch(new Fetch("Name","DirectChildrenCount"));
        storyRequest.setWorkspace(workspaceRef);
        storyRequest.setQueryFilter(new QueryFilter("FormattedID", "=", "US16"));

        QueryResponse storyQueryResponse = restApi.query(storyRequest);
        JsonObject storyJsonObject = storyQueryResponse.getResults().get(0).getAsJsonObject();
        System.out.println(storyJsonObject.get("Name") + " DirectChildrenCount: " + storyJsonObject.get("DirectChildrenCount"));
    }