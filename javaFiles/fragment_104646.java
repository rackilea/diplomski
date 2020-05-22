@RequestMapping("/Loginsucess")
    public String sucessRedirect(Model model) {

        model.addAttribute("User", new User()); 
        return "Loginsucess";
    }

@RequestMapping("/userRedirect")
    public String listContacts(/*Model model*/) {

        //model.addAttribute("User", new User()); 
        return "userRedirect";
    }
@RequestMapping("/usertype")
    public String listContacts(/*Model model*/) {

        //model.addAttribute("User", new User()); 
        return "usertype";
    }