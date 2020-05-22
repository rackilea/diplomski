@Service
public class SomeServiceImpl {

    private final CustomerDAO customerDAO;

    @Autowired
    public SomeServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO= customerDAO;
    }
}