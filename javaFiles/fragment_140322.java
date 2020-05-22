.prepareSearch("user_index")
            .setTypes("account_record")
            .setSearchType(SearchType.QUERY_THEN_FETCH)
            .setSize(0)
            .addAggregation(
                    AggregationBuilders.terms("updates_by_user")
                    .script(new Script("doc['accountNumber'].value"))
            )
            .execute().actionGet();