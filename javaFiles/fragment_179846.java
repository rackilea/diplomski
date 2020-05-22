@Controller
public class RoleController {
  @Autowired
  private RoleService roleService;

  // Index of roles
  @GetMapping("/roles")
  public String getRoles(Model model) {
    List<Role> roles = roleService.findAll();
    model.addAttribute("roles", roles);
    return "role/index";
  }

  // New role form
  @GetMapping("/roles/add")
  public String newRoleForm(Model model) {
    if(!model.containsAttribute("role")) {
      model.addAttribute("role", new Role());
    }
    model.addAttribute("action","/roles");
    model.addAttribute("heading","New Role");
    model.addAttribute("submit","Add");
    return "role/form";
  }

  // Add new role
  @PostMapping(value = "/roles")
  public String addNewRole(@Valid Role role, BindingResult result, RedirectAttributes redirectAttributes) {
    if(result.hasErrors()) {
      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.category",result);
      redirectAttributes.addFlashAttribute("role", role);
      return "redirect:/roles/add";
    }
    roleService.save(role);
    redirectAttributes.addFlashAttribute("flash", new FlashMessage("Role successfully added!", FlashMessage.Status.SUCCESS));
    return "redirect:/roles";
  }
}