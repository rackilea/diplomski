WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE); 
wifiManager.add(conf);

List<WifiConfiguration> list = wifiManager.getConfiguredNetworks();
for( WifiConfiguration i : list ) {
    if(i.SSID != null && i.SSID.equals("\"" + networkSSID + "\"")) {
         wm.disconnect();
         wm.enableNetwork(i.networkId, true);
         wm.reconnect();                
         break;
    }           
}