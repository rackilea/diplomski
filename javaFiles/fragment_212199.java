@Service
public class MyDataService {

    @Autowired
    private MyDataRepository myDataRepository;

    public MyDataResponse getMyData(Long id) {

        MyDataEntity entity = myDataRepository.findOne(id);
        ...rest logic, copy necessary data to MyDataResponse
    } 
}