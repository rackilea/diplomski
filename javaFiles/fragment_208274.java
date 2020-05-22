RallyRestApi restApi = new RallyRestApi(new URI("https://rally1.rallydev.com"), "user@company.com", "password");

JsonObject newTestCase = new JsonObject();
newTestCase.addProperty("Name", "Awesome Test");
CreateRequest createRequest = new CreateRequest("testcase", newTestCase);
CreateResponse createResponse = restApi.create(createRequest);

String newTestCaseRef = createResponse.getObject().get("_ref").getAsString();