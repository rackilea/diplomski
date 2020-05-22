@RestController
@RequestMapping("/")
public class EchoController
{
    private final Consumer<String> requestConsumer; // consumer to send signal to the flux

    public EchoController()
    {
        List<Consumer<String>> requestConsumerHolder = new ArrayList<>(); // temporary holder

        Flux<String> stringFlux = Flux.create(fluxSink ->
            requestConsumerHolder.add(fluxSink::next)); // when consumer accepts string it calls FluxSink.next

        stringFlux
            .doOnNext(System.out::println) // print string on next
            .subscribe();

        requestConsumer = requestConsumerHolder.get(0);
    }

    @PostMapping("/echo")
    public Mono<String> echo(@RequestBody Mono<String> request)
    {
        return request.doOnNext(requestConsumer); // send string to the flux on next
    }
}