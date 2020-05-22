@Controller    
@RequestMapping(path="/demo") 
public class MainController {

   @Autowired 
   private UserRepository userRepository;

   @Autowired 
   private pge pge;

   @GetMapping(path="/add")
   public @ResponseBody String addNewUser () { 
    pge.pgl();    //here's the code to add data in mysql
    return "Saved";
   }
}