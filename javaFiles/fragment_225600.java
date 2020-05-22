@Controller
public class MyController {

 @GetMapping("/adminMain")
 public String adminPage() {
     return "adminMain";
 }

}