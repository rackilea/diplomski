TermsLookup termsLookup = new TermsLookup("users", "user", "2", "followers");
TermsQueryBuilder terms = QueryBuilders.termsLookupQuery("user", termsLookup);

client.prepareSearch("tweets")
    .setQuery(terms)
    .execute().actionGet();