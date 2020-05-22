@Stateless
public class PersonServiceImpl implements PersonService {

    @EJB
    private RemotePersonService remotePersonService;

    // Let your test instantiate a mock service and wire it into your test instance using this constructor.
    public PersonServiceImpl(RemotePersonService rps) {
        this.remotePersonService = rps;
    }

    @Override
    public long countPersons() {
         return remotePersonService.getAllPersons().size();
    }
}