public class TestClass {
@Inject
Application application;

final AccountService accountServiceMock = mock(AccountService.class);

@Before
public void setup() {
    Module testModule = new AbstractModule() {
        @Override
        public void configure() {
            bind(AccountService.class).toInstance(accountServiceMock);
        }
    };

    GuiceApplicationBuilder builder = new GuiceApplicationLoader()
            .builder(new ApplicationLoader.Context(Environment.simple()))
            .overrides(testModule);
    Guice.createInjector(builder.applicationModule()).injectMembers(this);

    Helpers.start(application);
}

@Test
public void testMethod() throws Exception {
    RequestBuilder request = new RequestBuilder()
            .session("userId", "1")
            .uri(controllers.routes.AccountController.addAccount().url());

    running(application, () -> {
        when(accountServiceMock.addAccount().thenReturn(true);
        assertEquals(OK, route(request).status());
    });
}