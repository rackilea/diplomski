@Controller
 @RequestMapping("/st")
 public class TstCnt {

 @RequestMapping(value = "/test", method = RequestMethod.GET)      
 public String tst(){
     return "test";
   }
 }