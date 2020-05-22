@RestController
@RequestMapping("/api/client")
public class ClientController {
    @PostMapping
    public ResponseEntity createNewClient(@RequestBody @Valid Client client) {
        // insert client
        return new ResponseEntity(HttpStatus.CREATED);
    }
}