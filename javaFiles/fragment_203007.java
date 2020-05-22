@GetMapping("/view/{id}")
    public Map<String, Object> view(@PathVariable final String id) {
    System.out.println("id="+id);
    SearchResponse response = client
    .prepareSearch("user_detail").setTypes("user").setQuery(QueryBuilders.matchQuery("first_name", id))
    .setExplain(true)
    .execute().actionGet();

    SearchHit[] results = response.getHits().getHits();

    System.out.println("Current results: " + results.length);
    for (SearchHit hit : results) {
        System.out.println("------------------------------");
        Map<String, Object> result = hit.getSource();
        System.out.println("result="+ result);
        return result;
    }
    return null;
}