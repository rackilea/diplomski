WifiManager wifiManager = (WifiManager)
context.getSystemService(Context.WIFI_SERVICE);
WifiInfo wifiInfo = wifiManager.getConnectionInfo();
String ssid = wifiInfo.getSSID();
int networkid = wifiInfo.getNetworkId();
Toast.makeText(context, "OK " + ssid, Toast.LENGTH_LONG).show();
Toast.makeText(context, "Network ID  " + networkid,             
Toast.LENGTH_LONG).show();