from("timer://foo?fixedRate=true&period=120000")
    .log("Checking for files")
    .setHeader("Authorization", simple(myHttp.getAuth()))
    .setHeader("CamelHttpMethod", constant("GET"))
    .to(myHttp.getFullRequest())
    .unmarshal().json(JsonLibrary.Jackson, RestResponse.class)
    .to(....);