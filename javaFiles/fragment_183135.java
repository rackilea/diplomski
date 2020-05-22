@RequestMapping(value="/Login",method = RequestMethod.POST)
public RedirectView loginValidate(HttpServletRequest req, RedirectAttributes redir){
...

    redirectView= new RedirectView("/foo",true);
    redir.addFlashAttribute("USERNAME",uname);
    return redirectView;
}