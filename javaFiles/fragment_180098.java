@RestController
@RequestMapping("/greet")
public class GreetingService {
    // it's a public rest endpoint
    @PreAuthorize("permitAll()")
    @RequestMapping("/public")
    public void doGreetToPublicUsers() {...}

    // it's a protected rest endpoint
    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/protected")
    public void doGreetToProtectedUsers() {...}

    // it's a role protected rest endpoint
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/admin")
    public void justForAdmin() {...}
}