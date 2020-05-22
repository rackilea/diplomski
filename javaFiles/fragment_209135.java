StringRequestEntity requestEntity = new StringRequestEntity(
    JSON_STRING,
    "application/json",
    "UTF-8");

PostMethod postMethod = new PostMethod("http://localhost:8080/api/trade/createrequisition");
postMethod.setRequestEntity(requestEntity);

int statusCode = httpClient.executeMethod(postMethod);