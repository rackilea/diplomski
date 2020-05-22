String dateParams = "sysparm_query=" + URLEncoder.encode("col_updated_on>=2017-09-30", "UTF-8"); //Encode your query params here
String uri = "https://servicenowAPIadd.com/api/now/table?" + dateParams;
RestAssured
    .given()
    .urlEncodingEnabled(false)
    .get(uri);