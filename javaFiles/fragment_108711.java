public <T> T getRequestAndCheckStatus(final String url, final Class<T> returnTypeClass,
                                          final List<MediaType> mediaTypes,
                                          final Map<String, String> headerParams,
                                          final Map<String, Object> queryParams) throws Exception {

        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(mediaTypes);
        setHeaderParamsIfExists(headers, headerParams);
        final HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url);
        setQueryParamsIfExists(uriBuilder, queryParams);

        final ResponseEntity<T> entity = restTemplate
                .exchange(getUrl(uriBuilder),
                          HttpMethod.GET,
                          requestEntity,
                          returnTypeClass);

        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
        return entity.getBody();
    }

    private void setHeaderParamsIfExists(HttpHeaders headers, Map<String, String> headerParams) {
        if(headerParams != null && !headerParams.isEmpty())
            headerParams.entrySet()
                    .forEach(entry -> headers.set(entry.getKey(), entry.getValue()));
    }

    private void setQueryParamsIfExists(UriComponentsBuilder uriBuilder, Map<String, Object> queryParams) {
        if(queryParams != null && !queryParams.isEmpty())
            queryParams.entrySet()
                    .forEach(entry -> uriBuilder.queryParam(entry.getKey(), entry.getValue()));
    }

    private URI getUrl(UriComponentsBuilder uriBuilder) {
        return uriBuilder.build().encode().toUri();
    }