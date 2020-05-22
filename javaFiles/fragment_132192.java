// 2nd-level nested filter
FilterBuilder detailsView = FilterBuilders.nestedFilter("details.views", 
    FilterBuilders.termFilter("details.views.id", id));

// 1st-level nested filter
FilterBuilder details = FilterBuilders.nestedFilter("details", detailsView);

// ids constraint
IdsQueryBuilder ids = QueryBuilders.idsQuery(this.type).addIds("123");

SearchRequestBuilder srq =  this.client.prepareSearch(this.indexName)
   .setTypes(this.type)
   .setQuery(ids)
   .setPostFilter(details);