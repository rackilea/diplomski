public interface WifiStatus{
    boolean isConnected();//
}

public class Performer{
    WifiStatus wifiStatusProvider;
    public Performer(WifiStatus stateProvider){
        this.wifiStatusProvider = stateProvider;
    }

    public boolean performSomething() {
        //if (WIFI_STATE != "connected") {
        if (wifiStatusProvider.isConnected() != true) {            
            return false;
        }else{
            ....
        }
    }
}