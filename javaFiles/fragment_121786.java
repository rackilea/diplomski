MultiSearchRequestBuilder sr = client.prepareMultiSearch();
for (String formula : formulae) {
    SearchRequestBuilder srb = client
            .prepareSearch(index)
            .setSource(formula);
    sr.add(srb);
}
MultiSearchResponse resp = sr.execute().actionGet();