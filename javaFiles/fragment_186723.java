@Service
public class ServiceClassImpl implements ServiceClass {

    @Autowired
    RepositiryClass repositriyClass;

    @Override
    public List<Domain> getAll() {

        return repositriyClass.get();
    }

}