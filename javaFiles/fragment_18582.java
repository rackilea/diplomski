try (RestHighLevelClient client = new RestHighLevelClient(
        RestClient.builder(HttpHost.create("http://localhost:9200")))) {
    CreateIndexRequest createIndexRequest = new CreateIndexRequest("index_name");
    createIndexRequest.settings(Settings.builder()
            .put("index.number_of_shards", 3)
            .put("index.number_of_replicas", 1)
            .build());
    client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
    BulkRequest bulkRequest = new BulkRequest();
    XContentBuilder builder = XContentFactory.jsonBuilder()
            .startObject()
                .field("foo", "bar")
            .endObject();
    IndexRequest indexRequest = new IndexRequest("index_name");
    indexRequest.source(builder);
    bulkRequest.add(indexRequest);
    BulkResponse response = client.bulk(bulkRequest, RequestOptions.DEFAULT);
    if (response.hasFailures()) {
        for (BulkItemResponse item : response.getItems()) {
            System.out.println(item.getFailureMessage());
        }
    }
} catch (IOException e) {
    e.printStackTrace();
}