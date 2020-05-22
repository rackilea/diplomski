@RestController
@RequestMapping(Paths.ROOT)
@Api(value = Paths.ROOT, description = "Endpoint for core testing")
public class Controller {

    @Autowired
    CredentialsService credentialsService;

    @GetMapping("/")
    String home() throws URISyntaxException {
        Credentials credentials = new Credentials("oliver", "exxeta123");
        credentialsService.secureCredentials(credentials);
        return credentialsService.accessCredentials().toString();
    }

    @GetMapping("/test")
    public String test() throws IOException {
        // http://127.0.0.1:8200/v1/sys/internal/ui/mounts/secret/mysecrets
        VaultConfig vc = new VaultConfig();
        String bearerToken = vc.clientAuthentication().login().getToken();
        System.out.println(bearerToken);
        // credentialsService.accessCredentials()

        // Sending get request
        //URL url = new URL("http://127.0.0.1:8200/v1/sys/internal/ui/mounts/secret/mysecrets");
        // URL updated to match readme.adoc
        URL url = new URL("http://127.0.0.1:8200/v1/kv/my-secret");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Authorization", "Bearer " + bearerToken);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String output;

        StringBuffer response = new StringBuffer();
        while ((output = in.readLine()) != null) {
            response.append(output);
        }

        in.close();
        // printing result from response
        return "Response: - " + response.toString();
    }

    @GetMapping(value = { "/add/{name}/{username}/{password}" })
    public ResponseEntity<String> addKey(@PathVariable(value = "name", required = false, name = "name") String name,
            @PathVariable(value = "username", required = false, name = "username") String username,
            @PathVariable(value = "password", required = false, name = "password") String password) throws URISyntaxException {
        Credentials credentials = new Credentials(username, password);
        credentialsService.secureCredentials(name, credentials);
        return new ResponseEntity<>("Add success: " + credentialsService.accessCredentials(name).getUsername(), HttpStatus.OK);
    }

    @GetMapping(value = {"/get", "/get/{name}"})
    public ResponseEntity<Credentials> getKey(@PathVariable(value = "name", required = false, name = "name") String name) {
        return new ResponseEntity<>(credentialsService.accessCredentials(name), HttpStatus.OK);
    }

    @GetMapping(value= {"/delete", "/delete/{name}"})
    public String removeKey(@PathVariable(value = "name", required = false, name = "name") String name) {
        return "Delete success: " + credentialsService.deleteCredentials(name);
    }

}