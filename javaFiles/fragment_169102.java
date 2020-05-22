@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
public String redirect(@RequestParam(value="name", required=false) String name, Model model) {
    if(name == null || name.length() == 0) {
        return "home";
    }
    model.addAttribute("name",name);
    return "loginPage";
}