@RequestMapping(value="/login",method= RequestMethod.GET )
public String login(){
    return "login";
}

@RequestMapping(value="/loginfailed", method= RequestMethod.GET )
public String loginError(Model model){
    model.addAttribute("error", "true");
    return "login";
}

@RequestMapping(value= "/logout", method = RequestMethod.POST)
public String logout(Model model){
    model.addAttribute("logout","true");
    return "login";
}

}