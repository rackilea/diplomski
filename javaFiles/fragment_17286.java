ExistsFilterBuilder filter=FilterBuilders.existsFilter("guides");
NestedFilterBuilder nested=FilterBuilders.nestedFilter("guides", filter);
QueryBuilder qb = QueryBuilders.filteredQuery(QueryBuilders.matchAllQuery(),nested);
TermsBuilder tbBrand = AggregationBuilders.terms("brand-ag").field("brand.name.name.raw").order(Terms.Order.term(true)).size(0);

SearchResponse sr = esClient.prepareSearch("cellphones").setTypes("cellphone").setQuery(qb)
            .addAggregation(tbBrand ).execute().actionGet();