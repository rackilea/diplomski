@RestController
public class Controller {

    @PostMapping("/etc")
    ResponseEntity<String> addA(@RequestBody A a) { //disabled validation here
        B tempB = a.getB();
        a.setB(null);
        validateA(a);
        a.setB(tempB);
        // continue logic
    }
}