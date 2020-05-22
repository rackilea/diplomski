private <T> T getResponse(final RestURI query, final TypeReference typeReference) throws IOException {
    T response = null;

    final RestResponse<Record> tempResponse = client.call(GET, query);

    if (isResponseOK(tempResponse, query)) {
        byte[] payloads = {};

        for (Record rec : tempResponse.getResponses()) {
            final byte[] payload = rec.getPayload();
            payloads = ArrayUtils.addAll(payloads, payload);
        }
        final Reader reader = newReader(payloads)
        response = jsonObjectMapper.readValue(reader, typeReference);
    }

    return response; //returns Map<String, AvailableInfo>
}