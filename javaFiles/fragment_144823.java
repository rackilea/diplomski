Promise<Pair<JsonNode,Integer>> jsonPromise = WS.url(url).get().map(
        new Function<WSResponse, Pair<JsonNode,Integer>>() {
            public Pair<JsonNode,Integer> apply(WSResponse response) {
                Integer status=response.getStatus();
                JsonNode json = response.asJson();
                return new Pair(json,status);
            }
        }
);