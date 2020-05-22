@RestController
public class ApiController {

    @GetMapping("/api/test")
    public String apiTest(@AuthenticationPrincipal Principal principal) {
        return "test " + principal;
    }
}