@Controller
public class MainController {

      @GetMapping("/register")
      public String register(Model model,Principal principal) {
        if(principal!=null){
          return "redirect:/";
        }
        else{
          UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();
          model.addAttribute(userRegistrationDTO);

          return "userregistration";
        }
      }

}