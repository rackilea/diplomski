@RestController
@GetMapping("people")
public class PersonController() {

     @Autowired
     private PersonService personService;

     @PostMapping
     public void home(@RequestBody Person person) {
         personService.insert(person);
     }
}