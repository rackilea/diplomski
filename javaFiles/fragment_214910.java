public static Promise<Result> img() {
    //path is sent as JSON in request body
    JsonNode path = request().body().asJson();

    Logger.debug("path -> " + path.get("path").asText());
    Path p = Paths.get(path.get("path").asText());
    File file = new File(path.get("path").asText());

    try {
        response().setHeader("Content-Type", Files.probeContentType(p));
    } catch (IOException e) {
        Logger.error("BUMMER!", e);
        return Promise.promise(new Function0<Result>() {
            @Override
            public Result apply() throws Throwable {
                return badRequest();
            }
        });
    }

    return toBytes(file).map(new Function<byte[], Result>() {
        @Override
        public Result apply(byte[] bytes) throws Throwable {
            return ok(bytes);
        }       
    }).recover(new Function<Throwable, Result>() {
        @Override
        public Result apply(Throwable t) throws Throwable {
            return badRequest(t.getMessage());
        }
    });
}