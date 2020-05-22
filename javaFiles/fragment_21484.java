Response response =  given()
    .queryParam("logintoken", logintoken)
    .when()
    .get("/sso/login")
    .then().assertThat().statusCode(200).extract().response();

//Extract response body as a string
String html = response.asString();

//Parse extracted html with Jsoup
Document document = Jsoup.parse(html);

//Get <body> element from html
Element body = document.body();

//Extract text from <body> element
String bodyText = body.ownText();

//Parse extracted text using Jackson's ObjectMapper
Map<String, Object> map = new HashMap<>();
ObjectMapper mapper = new ObjectMapper();

//Configure Jackson to work with unquoted fields and single quoted values
mapper.configure(Feature.ALLOW_SINGLE_QUOTES, true);
mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

try {
  map = mapper.readValue(String.valueOf(bodyText), new TypeReference<Map<String, Object>>() {});
} catch (Exception e) {
  e.printStackTrace();
}

System.out.println(map.get("serviceUrl"));