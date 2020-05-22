@Field(analyze = Analyze.NO)
@NumericField
@Field(name = "productCategoryId_facet", analyze = Analyze.NO, bridge = @FieldBridge(impl = org.hibernate.search.bridge.builtin.LongBridge.class))
@Facet(forField = "productCategoryId_facet", encoding = FacetEncodingType.STRING)
private Long productCategoryId;
// Then use productCategoryId_facet instead of productCategoryId in your facet-enabled queries