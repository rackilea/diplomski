class ProviderTest {
    var injector : Injector = null

    @Before
    def setUp() {
        injector = Guice.createInjector(
            new BindModule1(),
            new BindModule2(),
            new BindGlobals()
            )
    }

    @After
    def tearDown()  {
    }

    @Test   def InjectedClass1WasBound()  {
        val provider = injector.getProvider(classOf[InjectedClass1])
    }

    @Test   def InjectedClass2WasBound() {
        val provider = injector.getProvider(classOf[InjectedClass2])
    }   
}