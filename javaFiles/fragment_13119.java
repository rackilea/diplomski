public void test123() {         
String postData = input.readFromTextFile(System.getProperty("user.dir") + "\\src\\test\\resources\\inputFile\\CurlDataFile.txt");
        RestAssured.baseURI = "MY URL";
Response r = (Response)given().contentType("application/json").body(postData).when().post("");
            String responseBody = r.getBody().asString();           
            String curlResponse = //I am providing expected Curl response here          
       //JSON Assertion for matching Expected and Actual response
            JSONAssert.assertEquals(curlResponse, responseBody, false);
        }