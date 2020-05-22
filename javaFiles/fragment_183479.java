@Controller
public class ApiController {
    private final Service service;
    public ApiController(Service service) {
        this.service = service;
    }
    @GetMapping( "/activate")
    public CompletableFuture<Void> activate(...){
        return service.activateUser(...)
               .exceptionally(throwable -> ... exception handling goes here ...)
    }
}

@Service
public class Service {
    @Async
    public CompletableFuture<Void> activateUser(...) {
        CompletableFuture<Void> future = new CompletableFuture<>();
        ... your code goes here ...
        if(someCondition){
           future.completeExceptionally(new GeneralSecurityException());
        } else {
           future.complete(null);
        }
        return future;
    }
}