MultiSearchRequest request = new MultiSearchRequest();

    request.add(formSearchRequestForMultiSearch(index, type, ID_FIELD, word));
    request.add(formSearchRequestForMultiSearch(index, type, PROVIDER_ID_FIELD, word));
    request.add(formSearchRequestForMultiSearch(index, type, LEGAL_NUMBER_FIELD, word));
    request.add(formSearchRequestForMultiSearch(index, type, OWNER_FIELD, word));
    request.add(formSearchRequestForMultiSearch(index, type, STATUS_FIELD, word));
    request.add(formSearchRequestForMultiSearch(index, type, START_DATE_FIELD, word));
    request.add(formSearchRequestForMultiSearch(index, type, END_DATE_FIELD, word));
    request.add(formSearchRequestForMultiSearch(index, type, PRODUCT_CODE_FIELD, word));
    request.add(formSearchRequestForMultiSearch(index, type, SUBPRODUCT_CODE_FIELD, word));
    request.add(formSearchRequestForMultiSearch(index, type, CUSTOM_STATUS_FIELD, word));
    request.add(formSearchRequestForMultiSearch(index, type, SUB_STATUS_FIELD, word));

    MultiSearchResponse searchResponse;
    try (RestHighLevelClient client = getClient()) {
        searchResponse = client.multiSearch(request);
    } catch (IOException e) {
        throw new CommonUserException(ELASTIC_EXCEPTION, ELASTIC_EXCEPTION);
    }
    Collection<Map<String, Object>> contracts = new LinkedList<>();
    for (int i = 0; i < searchResponse.getResponses().length; i++) {
        SearchHit[] hits = searchResponse.getResponses()[i].getResponse().getHits().getHits();
        for (SearchHit hit : hits) {
            contracts.add(hit.getSourceAsMap());
        }
    }
    return contracts;
}

private SearchRequest formSearchRequestForMultiSearch(String index, String type, String field, String word) {
    SearchRequest searchRequest = new SearchRequest(index);
    searchRequest.types(type);
    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    searchSourceBuilder.query(QueryBuilders.wildcardQuery(field, word));
    searchRequest.source(searchSourceBuilder);
    return searchRequest;
}