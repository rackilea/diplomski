/**
 * @return
 */
@RequestMapping(value = { "/loginProcessor" }, method = RequestMethod.POST)
public String loginProcessor(@ModelAttribute Login login) {
    System.out.println("PASSWORD: " + login.getPassword());
    return "forward:/login";
}