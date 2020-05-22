@Controller
   @RequestMapping("/hello")
   public class ShowController {

   @Autowired
   private YourRepository yr;

   @RequestMapping(value = "/getObjects", method = RequestMethod.GET)
       public List<Object> home(Model model) {
       List<Object> objects = yr.getObjects();
       return objects;
       }

}