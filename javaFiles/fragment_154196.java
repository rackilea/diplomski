@Component
public class TestUrlHandler {

    @Autowired
    private TestUrlService testUrlService;

    public Mono<ServerResponse> testUrls(ServerRequest request) {

        ParallelFlux<TestUrlResult> results = request.bodyToMono(String[].class)
                .flatMapMany(Flux::fromArray)
                .flatMap(url -> testUrlService.testUrls(url))
                .doOnComplete(() -> System.out.println("Testing of URLS is done."));

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(results, TestUrlResult.class);
    }
}