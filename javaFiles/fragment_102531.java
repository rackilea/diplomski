@RestController
@RequestMapping(value = "/manager")
public class ManagerController {

    @Autowired
    Manager manager;

    @PostMapping(value = "/store-something")
    private ResponseEntity<?> storeSomething(String str) {
        manager.storeSomething(str);
        return new ResponseEntity<>(CREATED);
    }
}


@Component
public class Manager {

    @Autowired
    private Storage storage;

    public void storeSomething(String str) {
        storage.store(str);
    }
}


public interface Storage {
    void store(String str);
}

@Service
public class StringStorage implements Storage {
    Map<String, String> stringMap = new HashMap<>();

    @Override
    public void store(String str) {
        stringMap.put(str, str);
    }
 }




@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}