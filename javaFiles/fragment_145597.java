@RequestMapping(value="/home")
public String home(Principal principal) {
    /*  
      Spring will inject the prinical for you.
      Then you can call getName() to get the username;
    */
    String user = principal.getName();  
    // do stuff with user
    return "home";
}