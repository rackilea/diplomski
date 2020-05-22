WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
List<ScanResult> networkList = wifi.getScanResults();

//get current connected SSID for comparison to ScanResult
WifiInfo wi = wifi.getConnectionInfo();
String currentSSID = wi.getSSID();

    if (networkList != null) {
        for (ScanResult network : networkList)
        {
           //check if current connected SSID
           if (currentSSID.equals(network.SSID)){
            //get capabilities of current connection
            String Capabilities =  network.capabilities;        
            Log.d (TAG, network.SSID + " capabilities : " + Capabilities);

            if (Capabilities.contains("WPA2")) {
               //do something
            }
            else if (Capabilities.contains("WPA")) {
               //do something
            }
            else if (Capabilities.contains("WEP")) {
               //do something
            }
           }
        }
    }