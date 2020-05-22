@Service
public class OnDemandService {

    @Async
    public void processTheRequest() {
        OnDemand.processtherequest();
    }

}