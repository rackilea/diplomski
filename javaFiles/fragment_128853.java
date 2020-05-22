private static Promise<JsonNode> getPromise(String url, Predicate<JsonNode> predicate) {
    return WS.url(url).get().map(response -> {
        JsonNode json = response.asJson();           
        if (predicate.negate().test(json)) {
            throw new Exception("BUMMER!");
        }
        return json;
    });
}

public static Promise<Result> reactiveCombo(List<String> urls) {
    List<Promise<JsonNode>> promises = new ArrayList<Promise<JsonNode>>(urls.size());
    Predicate<String> predURL = p -> p.contains("goodApi");
    Predicate<JsonNode> pred1 = p -> p.has("boolField") && p.get("boolField").asBoolean();
    Predicate<JsonNode> pred2 = p -> p.has("someField");

    urls.forEach(url -> {
        Promise<JsonNode> promise = predURL.test(url) ? getPromise(url, pred1) : getPromise(url, pred2);           
        promises.add(promise);
    });

    return Promise.sequence(promises).map(results -> ok()).recover(t -> badRequest());
}