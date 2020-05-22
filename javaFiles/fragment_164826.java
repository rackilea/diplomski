@RestController
@EnableWebMvc
public class WebController {

    @Autowired
    private CallRecording callRecording;

    @PutMapping(path = "/cdrpostbox/callrecording/{hostedAccountId}/{mp3FileName:.+}")
    public ResponseEntity<Object> callRecording(@PathVariable("hostedAccountId") String hostedAccountId, @PathVariable("mp3FileName") String mp3FileName, @RequestBody byte[] requestBody) {
        return ResponseEntity.status(callRecording.service(hostedAccountId, mp3FileName, requestBody)).body(null);
    }