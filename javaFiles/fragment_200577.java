@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/{id}")
    public Optional<Person> get(@PathVariable String id) {
        return personRepository.findById(id);
    }

    @GetMapping("/")
    public List<Person> getAll() {
        return personRepository.findAll();
    }

}