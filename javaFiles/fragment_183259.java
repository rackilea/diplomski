@RestController
@RequestMapping("/fetchdata")
public class Microservice2Controller {  
@Autowired
Microservice1Client microservice1Client;

    @GetMapping(value = "/")
public ResponseEntity<Microservice2ResponseWrapper<List<Customer2>>> getAll() {     
            return microservice1Client.getAll();          
    }   
}