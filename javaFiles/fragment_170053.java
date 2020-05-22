RestAssured.baseURI = "https://stash.test.local";
RestAssured.basePath = "/rest/api/1.0/projects/DEV/repos/central-project/branches";
RestAssured.authentication = RestAssured.preemptive().basic(
                    username, password);
Response response = RestAssured.get();
String branchJSON = response.asString();