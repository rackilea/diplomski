SearchResponse response = NodeClient().prepareSearch("index-name")
    .setTypes("user")
    .setSource("id")             <---- list the fields you want to retrieve
    .setFrom(0)
    .setSize(1000)               <---- increase this is you have more documents
    .execute().actionGet();

for (SearchHit hit : response.getHits()) { 
    String id = hit.getSource().get("id");
    // do something with the id value
}