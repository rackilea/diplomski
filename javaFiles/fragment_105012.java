@WebService(endpointInterface = "com.enterprise.ws.WebServiceInterface")
public class WebServiceImpl implements WebServiceInterface{

    @Override
    public String[] listSample() {
        return new String[]{"1212"};
    }
}