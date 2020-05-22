@Service
public class SampleDataService {

    @Autowire 
    SampleDataRepo repo;

    public SampleData saveSampleData() {
        SampleData sd = new SampleData();
        sd.setSample("longtest");

        repo.save(sd);
    }
}