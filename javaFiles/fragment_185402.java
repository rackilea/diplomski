@Controller
@RequestMapping("/users")
public class UserController {

    @EJB(mappedName="java:global/KSC/UserService!com.ksc.services.UserService")
    private UserService service;

    @RequestMapping(value = "")
    public String index(ModelMap model) {
        model.addAttribute("records", service.findAll());
        return "user/index";
    }

    @RequestMapping(value = "/create")
    public String create(ModelMap model) {
        model.addAttribute("record", new KCSUser());
        return "user/edit";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(ModelMap model, @PathVariable("id") int userId) {
        KCSUser user = service.find(userId);
        // Assert.notNull(user, "user was not found");
        model.addAttribute("record", user);
        return "user/edit";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(ModelMap model, @PathVariable("id") int userId) {
        KCSUser user = service.find(userId);
        // Assert.notNull(user, "user was not found");
        service.remove(user);

        return index(model);
    }
}