private class WifiScanReceiver extends BroadcastReceiver {
    public void onReceive(Context c, Intent intent) {
        List<ScanResult> wifiScanList = wifi.getScanResults();
        // Do whatever you wish to do with ScanResult
    }
}