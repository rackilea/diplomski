@ControllerAdvice
public class UserControllerAdvice {

  @ModelAttribute
  public void addUserAttribute() {

   Object currentUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

   if ("anonymousUser".equals(currentUser.toString())) {
       model.addAttribute("username","GUEST");
   } else {
       UserDetails user = (UserDetails) currentUser;
       String name = this.userRepository.findByEmail(user.getUsername()).getFullName();
       model.addAttribute("username",name);
   }
}