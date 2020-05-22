@EnableTransactionManagement
@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    private PersonRepositoryAlbany personRepositoryAlbany;

    @Autowired
    private PersonRepositoryBuffalo personRepositoryBuffalo;

    @GetMapping("/albany")
    public List<Person> albany() {
        return getPersonsAlbany();
    }

    @GetMapping("/buffalo")
    public List<Person> buffalo() {
        return getPersonsBuffalo();
    }

    @Transactional("albanyTransactionManager")
    public List<Person> getPersonsAlbany() {
        return personRepositoryAlbany.findAll();
    }

    @Transactional("buffaloTransactionManager")
    public List<Person> getPersonsBuffalo() {
        return personRepositoryBuffalo.findAll();
    }

}