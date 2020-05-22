public class SomeResource {
    @Inject
    private Paginator paginator;
    @Inject
    private ProductRepository productRepository;
    @Inject
    private SpecificationBuilder specificationBuilder;
    @Inject
    private FluentAssembler fluentAssembler;

    public void someMethod() {
        Page<ProductDto> page = fluentAssembler.assemble(
                paginator.paginate(productRepository)
                    .byPage(1)
                    .ofSize(10)
                    .matching(specificationBuilder.of(Product.class)
                        .property("discontinued").equalTo(true)
                        .build()))
                .toPageOf(ProductDto.class)
    }
}