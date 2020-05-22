@GetMapping(value = {"/", "/login", "/home", "/index"})
public String getLoginForm(Model model) {
    logger.info("GET request to " + LOGIN_PAGE);
    model.addAttribute("clientForm", new ClientForm());
    return LOGIN_PAGE;
}