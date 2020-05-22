@RestController
public class GreetingController {

    @GetMapping("/greetings")
    public Mono<Greeting> greeting(ServerHttpRequest request) {

        return Mono.just(new Greeting("Hello..." + request.getURI().toString()));
    }
}