@RequestMapping(value="/load_search") 
public String load_search(ModelMap model, @ModelAttribute Foo foo, 
            HttpServletRequest request, RedirectAttributes redirectAttrs) {

    Foo foo = myService.getFoo();
    redirectAttrs.addFlashAttribute("foo", foo);
    return "redirect:/search";
}