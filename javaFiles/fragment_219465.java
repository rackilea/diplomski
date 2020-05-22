TermsLookupQueryBuilder terms = QueryBuilders.termsLookupQuery("user")
    .lookupIndex("users")
    .lookupType("user")
    .lookupId("2")
    .lookupPath("followers");

client.prepareSearch("tweets")
    .setQuery(terms)
    .execute().actionGet();