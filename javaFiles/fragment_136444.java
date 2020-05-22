@Service
public class WebServiceRefreshService {

  public static final int SERVICE_CALL_RATE_MILLISECONDS = 60 * 1000;

 @Scheduled(fixedRate = SERVICE_CALL_RATE_MILLISECONDS)
    public void refreshFromWebService() {
      //do stuff
    }
}