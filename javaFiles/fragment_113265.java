Response response = when().get("http://nowjidev1vm01.ath.bskyb.com/calskyplussearch/health");
        response
                .then()
                .statusCode(200);

        // compares two JSON documents
        assertJsonEquals(resource("resource-inside-resources-folder.json"), response.asString());