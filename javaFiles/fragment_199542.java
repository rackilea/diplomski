@RequestMapping(method = RequestMethod.GET) 
    public String viewModificationForm(Model model) {
        Hito hitoForm = new Hito();
        model.addAttribute("hitoForm", hitoForm);
        return "main"; 
    }