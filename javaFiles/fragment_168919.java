public interface CRUDService<T> {
    List<T> listAll();

    T getById(Long id);

    T saveOrUpdate(T domainObject);

    void delete(Long id);
}

@Service
public FirstService implements CRUDService<First>{
.........................
}

@Service
public SecondService implements CRUDService<Second>{
.........................
}

@RestController
public MyController {
    @Autowired
    private CRUDService<First> firstService;

    @Autowired
    private CRUDService<Second> secondService;

}