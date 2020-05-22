public class RMIConnectionService {

    public DeviceService connect(String serverUrl) {
        RmiProxyFactoryBean factory = new RmiProxyFactoryBean();
        factory.setServiceInterface(DeviceService.class);
        factory.setServiceUrl("rmi://" + serverUrl + ":1099/SERVICE_URL");
        factory.afterPropertiesSet();
        //...
        return (DeviceService) factory.getObject();
    }
}