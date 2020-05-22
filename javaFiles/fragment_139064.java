ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
boolean isConnected = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnected();
this.wifiManager = (WifiManager) this.context.getSystemService(Context.WIFI_SERVICE);
String currentSSID = wifiManager.getConnectionInfo().getSSID();
/*
Surround your ssid with " when you compare it with the ssid of the wifimanager
because it will return your SSID surouded by quotes
*/
if(currentSSID.equals("\"" + your_net_ssid + "\"") && isConnected){
 //You are realy connected to the hospot
}else{
 //The connection dont exist
}