@Controller
public class MyController {

   @RequestMapping ("/pageA");
   public String handlePageA() {
      .. do stuff
   }

   @RequestMapping ("/pageB");
   public String handlePageB() {
      .. do stuff
   }
}