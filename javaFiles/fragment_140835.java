public interface AnimalFeedingService {

    @WebMethod
    void feed(@WebParam(name = "animal") Animal animal);

}

@WebService
@Service
public class AnimalFeedingServiceImpl implements AnimalFeedingService {
    @Override
    @WebMethod
    public void feed(@WebParam(name = "animal") Animal animal) {
        // Whatever
    }
}