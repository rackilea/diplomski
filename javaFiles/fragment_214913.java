public static Promise<Result> img() {
    //path is sent as JSON in request body
    JsonNode path = request().body().asJson();
    Logger.debug("path -> " + path.get("path").asText());
    Path p = Paths.get(path.get("path").asText());
    File file = new File(path.get("path").asText());        
    final String mime;

    try {
        mime = Files.probeContentType(p);            
    } catch (IOException e) {
        Logger.error("BUMMER!", e);
        return Promise.promise(new Function0<Result>() {
            @Override
            public Result apply() throws Throwable {
                return badRequest();
            }
        });
    }
    return toBytes(file).flatMap(new Function<byte[], Promise<Result>>() {
        @Override
        public Promise<Result> apply(final byte[] bytes) throws Throwable {
            return toSHA1(bytes).map(new Function<String, Result>() {
                @Override
                public Result apply(String sha1) throws Throwable {
                    if (setETagHeaders(sha1, mime)) {
                        return status(304);
                    }
                    return ok(bytes);
                }
            });
        }
    }).recover(new Function<Throwable, Result>() {
        @Override
        public Result apply(Throwable t) throws Throwable {
            return badRequest(t.getMessage());
        }
    });
}