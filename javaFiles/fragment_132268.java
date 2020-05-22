public class TestWebbRequestBin {

    @Test public void stackOverflow20543115() throws Exception {
        Webb webb = Webb.create();
        webb.setBaseUri("http://requestb.in");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("string", "string");
        String json = jsonObject.toString(); // {"string":"string"}

        Response<String> response = webb
                .post("/1g7afwn1")
                .header("Accept", "application/json")
                .header("Content-type", "application/json")
                .header("hmac", "some-hmac-just-a-test")
                .body(json)
                .asString();

        assertEquals(200, response.getStatusCode());
        assertTrue(response.isSuccess());

        String body = response.getBody();
        assertEquals("ok\n", body);
    }

}