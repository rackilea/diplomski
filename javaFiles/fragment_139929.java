public static JsonNode resultToJsonNode(final Result result, final long timeout, final Materializer mat)
    throws Exception {
    FiniteDuration finiteDuration = Duration.create(timeout, TimeUnit.MILLISECONDS);
    byte[] body = Await.result(
        FutureConverters.toScala(result.body().consumeData(mat)), finiteDuration).toArray();
    ObjectMapper om = new ObjectMapper();
    final ObjectReader reader = om.reader();

    return reader.readTree(new ByteArrayInputStream(body));
}