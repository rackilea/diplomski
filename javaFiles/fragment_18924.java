public class TestApp {

    @Inject <-- this is injected
    User user;
    @Inject <-- this is injected
    BackendService backendService; <-- Nothing inside this class will be injected