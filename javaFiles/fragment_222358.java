ArrayList<WiFiItem> listWifi = new ArrayList<WiFiItem>();
    wifiManager.startScan();
    scanResult = wifiManager.getScanResults();        
    for(ScanResult sc : scanResult) {
        WiFiItem wifiItem = new WiFiItem();
        wifiItem.setSSID(sc.SSID);
        wifiItem.setBSSID(sc.BSSID);           
        listWifi.add(wifiItem);
    }