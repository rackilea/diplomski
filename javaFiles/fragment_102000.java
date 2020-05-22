// note, here I did use PUT and no argument for @Validated annotation
@PutMapping("/cadastrar/sindico") 
public ModelAndView update(
    @Validated @ModelAttribute("usuario") Usuario usuario, 
    BindingResult validacao, 
    ModelMap model
) { ... }