SearchResponse response = client().prepareSearch("idx").setTypes("type")
                .setQuery(matchAllQuery())
                .addAggregation(terms("keys").field("key").size(3).order(Terms.Order.count(false)))
                .execute().actionGet();

Terms  terms = response.getAggregations().get("keys");
Collection<Terms.Bucket> buckets = terms.getBuckets();
assertThat(buckets.size(), equalTo(3));