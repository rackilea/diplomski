public Promise<JsonNode> consumeApi() throws Exception {
    return WS.url(REST_URL)
            .post("")
            .map(new Function<Response, JsonNode>() {
                public JsonNode apply(Response response) throws Throwable {
                    // BEGIN JACKSON RELEVANT CODE
                    return JsonUtils.walkJsonNode(response.asJson(), new JsonUtils.TextFixer() {
                        public String fix(String string) {
                            return StringEscapeUtils.unescapeHtml4(string);
                        }
                    });
                    // END JACKSON RELEVANT CODE
                }
            });
}