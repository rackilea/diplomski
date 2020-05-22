@PostMapping("/cadastrar/sindico")
public ModelAndView create(
    @Validated(UserCreateValidationGroup.class) @ModelAttribute("usuario") Usuario usuario, 
    BindingResult validacao, 
    ModelMap model
) { ... }