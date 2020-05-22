public static Promise<Result> reactiveCombo() {
    Promise<WSResponse> promise1 = WS.url("url1").get();
    Promise<WSResponse> promise2 = WS.url("url2").get();
    Promise<WSResponse> promise3 = WS.url("url3").get();

    return promise1.flatMap(response1 -> {
        final JsonNode json1 = response1.asJson();
        if (!json1.has("someField")) {
            return Promise.promise(() -> badRequest());
        }
        return promise2.flatMap(response2 -> {
            final JsonNode json2 = response2.asJson();
            if (json1.get("someField").asText().equals(json2.get("someField").asText())) {
                return Promise.promise(() -> badRequest());
            }
            return promise3.map(response3 -> {
                final JsonNode json3 = response3.asJson();
                if (json3.get("boolField").asBoolean()) {
                    return badRequest();
                }
                return ok();
            });
        });
    });
}