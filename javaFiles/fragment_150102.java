@Controller
 public class Student{
      @RequestMapping("/user/{id}")
      public String getUser(ModelMap model, @PathVariable String id) {
          // function that gets user id
          model.addAttribute("foo", "foo");
          return "bar";
      }
}