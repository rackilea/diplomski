public class SomeResource {
    @Inject
    private Paginator paginator;
    @Inject
    private ProductRepository productRepository;
    @Inject
    private FluentAssembler fluentAssembler;

    public void someMethod() {
        Page<Product> page = paginator.paginate(productRepository.discontinuedProducts())
                .byPage(1)
                .ofSize(10)
                .all();
    }
}