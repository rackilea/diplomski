public class SomeResource {
    @Inject
    private Paginator paginator;
    @Inject
    private ProductRepository productRepository;
    @Inject
    private SpecificationBuilder specificationBuilder;

    public void someMethod() {
        Page<Product> page = paginator.paginate(productRepository)
                .byPage(1)
                .ofSize(10)
                .matching(specificationBuilder.of(Product.class)
                    .property("discontinued").equalTo(true)
                    .build());
    }
}