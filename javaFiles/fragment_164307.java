RestAssured.given().contentType(ContentType.JSON)
                .header("Authorization", "Bearer "+srtToken)
                .with().body(postContent)
                .when().post(srtAmbiente+srtAPI).prettyPeek()
                .then().statusCode(200).contentType(ContentType.JSON)
                .assertThat().body("email", is(email));
    }