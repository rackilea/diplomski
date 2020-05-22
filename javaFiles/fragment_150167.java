...
 import javax.websocket.server.ServerEndpointConfig;

 public class MyConfigurator extends ServerEndpointConfig.Configurator {
 ...  
     private static final String ORIGIN = "http://www.example.com:7001";

     @Override
    public boolean checkOrigin(String originHeaderValue) {
        return ORIGIN.equals(originHeaderValue)   
    }
 }
 ...