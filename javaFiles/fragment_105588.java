@Component(property = {Constants.SERVICE_PID + "=com.acme.host", 
                       Constants.SERVICE_PID + "=com.acme.system"})
public class TestComponent implements ManagedService {

    @Override
    public void updated(Dictionary<String, ?> dict) {
    ...
    }