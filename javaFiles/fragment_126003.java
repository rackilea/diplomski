public String createEventDocument(Event document) throws Exception {
    GetIndexRequest request = new GetIndexRequest();
    request.indices(INDEX);
    boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
    if(!exists){
        createIndexWithMapping();
    }
    IndexRequest indexRequest = new IndexRequest(INDEX, TYPE, document.idAsString())
            .source(convertEventDocumentToMap(document));
    //create mapping with a complete field
    IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
    return indexResponse.getResult().name();
}

private boolean createIndexWithMapping() throws IOException {
            CreateIndexRequest createIndexRequest = new CreateIndexRequest(INDEX);
    XContentBuilder builder = XContentFactory.jsonBuilder();
    builder.startObject();
    {
        builder.startObject( "properties" );
        {
            builder.startObject( "name_suggest" );
            {
                builder.field( "type", "completion" );
            }
            builder.endObject();
        }
        builder.endObject();
    }
    builder.endObject();
    createIndexRequest.mapping(TYPE,builder);
    createIndexRequest.timeout(TimeValue.timeValueMinutes(2));
    CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
    return createIndexResponse.isAcknowledged();

}