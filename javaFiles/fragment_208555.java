given()
    .config(
        RestAssured.config()
            .xmlConfig(XmlConfig.xmlConfig()
                .declareNamespace("ns", "urn:service:com:namespace:item/1"))).
    when()
        .get(myUrl)
    .then()
        .body("'ns:RootNode'.'ns:Level1'.'ns:Level2'[0].'@ns:id'", equalTo("AN-ID-123"));