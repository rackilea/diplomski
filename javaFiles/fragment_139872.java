@Service
public class DatabaseAccessServiceImpl implements DatabaseAccessService {

    @Autowired
    private RestTemplate restTemplate;

    public void storeData(Data data){
         ...
         restTemplate.postForObject(...)
         ... 

    }

}