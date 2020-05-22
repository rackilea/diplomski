@Controller 
 public class MyController {

   @RequestMapping("/view/{name}")  
     public String myView(@PathVariable("name") String  name) {
      return name;   
   }

}