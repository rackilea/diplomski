//Check if this SSID is already stored. If it is, return that configuration.
//If not, return the configuration being tested.
public WifiConfiguration checkPreviousConfiguration(WifiConfiguration wc) {
    List<WifiConfiguration configs = wifi.getConfigurations();
    for(WifiConfiguration config : configs) {
        if(config.SSID.equals(wc.SSID)) return config;
    }
    return wc;
}

//......
int res = wifi.addNetwork(checkPreviousConfiguration(wc));