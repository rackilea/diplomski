public interface SphWebService {
   Object sphRemoteCall(String uri, Object requestPayload, String soapAction);
}

@Component
public class SphWebServiceImpl implements SphWebService {
   @Retryable
   public Object sphRemoteCall(String uri, Object requestPayload, String soapAction) {
       log.debug("Calling the sph for uri:{} and soapAction:{}", uri, soapAction);
       return getWebServiceTemplate().marshalSendAndReceive(uri, requestPayload, new SoapActionCallback(soapAction));
   }
}

@Service
public class SphIptvClient extends WebServiceGatewaySupport {

   @Autowired
   SphWebService sphWebService;

   @Retryable(maxAttempts=3, backoff=@Backoff(delay=100))
   public GetSubscriberAccountResponse getSubscriberAccount(String loginTocken, String billingServId) {
       GetSubscriberAccountResponse response = (GetSubscriberAccountResponse) this.sphWebService.sphRemoteCall(sphIptvEndPoint, getSubAcc, "xxxxx");
       return response;
   }
}

@Configuration
@EnableRetry
public class SphClientConfig {
   // the @Bean method was unnecessary and may cause confusion. 
   // @Service was already instantiating SphIptvClient behind the scenes.
}