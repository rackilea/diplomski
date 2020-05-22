URIBuilder builder = new URIBuilder("http://example.com/");
builder.setParameter("var1", "value1").setParameter("var2", "value2");

HttpGet request = new HttpGet(builder.build());

// get back the url parameters   
List<NameValuePair> params = builder.getQueryParams();