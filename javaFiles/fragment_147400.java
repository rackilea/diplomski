public class CreateStory {

    public static void main(String[] args) throws URISyntaxException, IOException {


           String host = "https://rally1.rallydev.com";
            String username = "user@co.com";
            String password = "secret";
            String wsapiVersion = "v2.0";
            String projectRef = "/project/2222";
            String workspaceRef = "/workspace/11111"; 
            String applicationName = "RestExample_createStory";


        RallyRestApi restApi = new RallyRestApi(
                new URI(host),
                username,
                password);
        restApi.setWsapiVersion(wsapiVersion);
        restApi.setApplicationName(applicationName);   



        try {
            for (int i=0; i<3; i++) {

                //Add a story  
                System.out.println("Creating a story...");
                JsonObject newStory = new JsonObject();
                newStory.addProperty("Name", "my story");
                newStory.addProperty("Project", projectRef);


                CreateRequest createRequest = new CreateRequest("hierarchicalrequirement", newStory);
                CreateResponse createResponse = restApi.create(createRequest);  
                if (createResponse.wasSuccessful()) {

                    System.out.println(String.format("Created %s", createResponse.getObject().get("_ref").getAsString()));          

                    //Read story
                    String ref = Ref.getRelativeRef(createResponse.getObject().get("_ref").getAsString());
                    System.out.println(String.format("\nReading Story %s...", ref));
                    GetRequest getRequest = new GetRequest(ref);           
                } else {
                    String[] createErrors;
                    createErrors = createResponse.getErrors();
                    System.out.println("Error occurred creating story: ");
                    for (int j=0; i<createErrors.length;j++) {
                        System.out.println(createErrors[j]);
                    }
                }
            }


        } finally {
            //Release all resources
            restApi.close();
        }   

    } 

}