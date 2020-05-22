public class aRESTcreateDefectHashMap {

    public static void main(String[] args) throws URISyntaxException, IOException {
            String host = "https://rally1.rallydev.com";
            String username = "user@co.com";
            String password = "secret";
            String wsapiVersion = "v2.0";
            String projectRef = "/project/12352608219";
            String workspaceRef = "/workspace/12352608129"; 
            String applicationName = "RestExample_createDefectWithHashMap";
     RallyRestApi restApi = new RallyRestApi(
            new URI(host),
            username,
            password);
     restApi.setWsapiVersion(wsapiVersion);
     restApi.setApplicationName(applicationName);   



     try {
         System.out.println("Creating a defect...");
         HashMap<String, String> defectHash = new HashMap<String, String>();
         defectHash.put("Name", "some defect 12345");
         defectHash.put("Project", projectRef);
         defectHash.put("c_MyKB", "in progress");         //custom dropdown field

         JsonObject newDefect = new JsonObject();

         Iterator it = defectHash.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pairs = (Map.Entry)it.next();
                System.out.println(pairs.getKey() + " = " + pairs.getValue());
                newDefect.addProperty(pairs.getKey().toString() ,pairs.getValue().toString() );
            }
            CreateRequest createRequest = new CreateRequest("defect", newDefect);
            CreateResponse createResponse = restApi.create(createRequest);
            if (createResponse.wasSuccessful()) {

                System.out.println(String.format("Created %s", createResponse.getObject().get("_ref").getAsString()));          

                //Read defect
                String ref = Ref.getRelativeRef(createResponse.getObject().get("_ref").getAsString());
                System.out.println(String.format("\nReading Defect %s...", ref));
                GetRequest getRequest = new GetRequest(ref);           
            } else {
                String[] createErrors;
                createErrors = createResponse.getErrors();
                System.out.println("Error occurred creating a defect: ");
                for (int j=0; j<createErrors.length;j++) {
                    System.out.println(createErrors[j]);
                }
            }



     } finally {
        restApi.close();
        }
    }