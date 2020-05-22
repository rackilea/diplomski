@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/welcome")
    public void welcomeMember(@RequestParam Map<String, String> data, HttpMethod method) {
        System.out.println(method);
        System.out.println(data);
    }   
}