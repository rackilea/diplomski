TermQueryBuilder incPlatformFilter = QueryBuilders.termQuery(IdxSchemaConstants.FULL_OFFER_ACTION_INCLUSIVE_PLATFORMS, platformId);

//For MissingQuerybuilder
//MissingFilterBuilder incPlatformEmptyFilter = FilterBuilders.missingFilter(IdxSchemaConstants.FULL_OFFER_ACTION_INCLUSIVE_PLATFORMS);
BoolQueryBuilder incPlatformEmptyFilter = new BoolQueryBuilder().mustNot(new ExistsQueryBuilder(IdxSchemaConstants.FULL_OFFER_ACTION_INCLUSIVE_PLATFORMS));
//NotFilterBuilder
//NotFilterBuilder excPlatformFilter = FilterBuilders.notFilter(FilterBuilders.termFilter(IdxSchemaConstants.FULL_OFFER_ACTION_EXCLUSIVE_PLATFORMS, platformId));
TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery(IdxSchemaConstants.FULL_OFFER_ACTION_EXCLUSIVE_PLATFORMS, platformId);
BoolQueryBuilder excPlatformFilter = new BoolQueryBuilder().mustNot(termQueryBuilder);

// ==> use a bool/filter to replace the "and" query <<==
QueryBuilder platformPartialMatched = QueryBuilders.boolQuery()
    .filter(excPlatformFilter)
    .filter(incPlatformEmptyFilter);