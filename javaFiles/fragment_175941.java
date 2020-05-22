@BeforeClass
public static void beforeEverything() {
    // runs just once before all tests
}

@Before
public void setup() {
    // runs before every test
} 

@After
public void breakdown() {
    // runs after every test
}

@AfterClass
public static void afterEverything() {
    // runs just once after all the tests
}