@Controller 
class MyController
{
    @ModelAttribute("user")
    public User getUser(HttpServletRequest request) 
    {
        return (User) request.getAttribute("user");
    }

    @RequestMapping(value = "someurl", method = RequestMethod.GET)
    public String HandleSomeUrl(@ModelAttribute("user") User user)  
    {
        // ... do some stuff
    }
}