@Controller
public class WelcomeController {
    @RequestMapping(value = "/welcome.htm")
    protected View welcome() {

        Set<String> roles = AuthorityUtils
                .authorityListToSet(SecurityContextHolder.getContext()
                        .getAuthentication().getAuthorities());
        if (roles.contains("ROLE_ADMIN")) {
            return new RedirectView("Admin.htm");
        }
        return new RedirectView("User.htm");
    }
}