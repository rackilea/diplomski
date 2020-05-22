@Override
    public FacetingRequest getMakeFacetRequest(QueryBuilder builder) {
        FacetingRequest facetingRequest = builder.facet()
                .name("make")
                .onField("make.label")
                .discrete()
                .orderedBy(FacetSortOrder.FIELD_VALUE)
                .includeZeroCounts(true)
                .maxFacetCount(10)
                .createFacetingRequest();
        return facetingRequest;
    }