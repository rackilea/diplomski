@SpringBootApplication
public class HelloworldApplication {
    private static final Logger LOG = LoggerFactory.getLogger(SillyNameMakerApp.class);
    private final App actionsApp = new SillyNameMakerApp();

    @Value("${TARGET:World}")
    String message;

    @RestController
    class HelloworldController {
        @GetMapping("/")
        String serveAck() {
            return "App is listening but requires valid POST request to respond with Action response.";
        }

        @RequestMapping(value = "/", method = RequestMethod.POST, produces = { "application/json" })
        String serveAction(@RequestBody String body, @RequestHeader Map<String, String> headers) {
            try {
                return actionsApp.handleRequest(body, headers).get();
            } catch (InterruptedException | ExecutionException e) {
                return handleError(e);
            }
        }

        private String handleError(Exception e) {
            e.printStackTrace();
            LOG.error("Error in App.handleRequest ", e);
            return "Error handling the intent - " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloworldApplication.class, args);
    }
}