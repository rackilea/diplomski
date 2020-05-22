private class TicketsResponseExtractor extends HttpMessageConverterExtractor<Tickets> {

    public TicketsResponseExtractor (Class<Tickets> responseType,
      List<HttpMessageConverter<?>> messageConverters) {
        super(responseType, messageConverters);
    }

    @Override
    public Tickets extractData(ClientHttpResponse response) throws IOException {

        if (response.getStatusCode() == HttpStatus.OK) {
            response.getHeaders().set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
            return super.extractData(response);             
        } else {
            return null;
        }
    }
}