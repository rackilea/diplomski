@RestController
@RequestMapping("/myController")
public class myController(){
   @GetMapping("/")
   public String get(){
      return "hello world";
   }
}