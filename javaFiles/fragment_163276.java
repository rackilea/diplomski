class CartTest : RestAssuredSupport {
    // ...
    var cartId: Int by Delegates.notNull()

    @Before fun setUp() {
        // Set up the cartId. This will run before each test. Use @BeforeClass to run once
    }

    @Test fun getCartForWebsite() { /* ... */ }
}