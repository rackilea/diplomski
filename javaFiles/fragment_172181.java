private <T> T getResponse(final RestURI query, 
    final BiFunction<CustomReader, ObjectMapper, T> mapper) throws IOException {
    T response = null;

    final RestResponse<Record> tempResponse = getResponseFromDataPath(query);

    if (isResponseOK(tempResponse, query)) {
        final CustomReader reader = createCustomReaderFromResponse(tempResponse);
        response = mapper.apply(reader, objectMapper); 
    }

    return response;
}