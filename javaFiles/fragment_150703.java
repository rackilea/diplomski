@Autowired
private ProductController productController;

@Autowired
private ProductService productService;

@Before
public void setUp() {
    ProductService productServiceSpy = Mockito.spy(productService);
    ReflectionTestUtils.setField(productController, "productService", productServiceSpy);
}