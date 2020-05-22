private Repository repository;
private String path;

@Autowired
public ClassToCreateFactory (Repository repository, @Value("${path}") String path) {
    this.repository = repository;
    this.path = path;
}    

public static ClassToCreate getClassToCreate() {
    return new ClassToCreate(repository, path);
}