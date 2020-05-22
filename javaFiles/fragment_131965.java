@RequestMapping("/rest/user")
public class UserController {

   @RequestMapping("{keyType}/{key}/orders")
   public ModelAndView orders(@PathVariable String keyType, @PathVariable String key) {
       User u = findUser(keyType, key);
       // ...
   }

   @RequestMapping("{keyType}/{key}/profile")
   public ModelAndView profile(@PathVariable String keyType, @PathVariable String key) {

       User u = findUser(keyType, key);
       // ...
   }

   @RequestMapping("{keyType}/{key}/address")
   public ModelAndView address(@PathVariable String keyType, @PathVariable String key) {
       User u = findUser(keyType, key);
       // ...
   }

   private User findUser(String keyType, String key) {
       // ...
   }
}