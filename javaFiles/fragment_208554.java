given().
        config(RestAssured.config().xmlConfig(XMLConfig.xmlConfig().declareNamespace("ns", "urn:service:com:namespace:item/1"))).
when().
        get(myUrl).
then().
        body("'ns:ItemRef'[0]", equalTo("door-123456.pdf"));