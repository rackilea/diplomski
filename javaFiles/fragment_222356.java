private void setNetworksList() {
    networksList = (ListView) findViewById(R.id.networkList);
    networksList.setOnItemClickListener(new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, final int position,
                                long id) {
            final int chosenPosition = position;
            WiFiItem wifiItem = new WiFiItem();
            wifiItem = (WiFiItem) parent.getItemAtPosition(position);
            networkSSID = wifiItem.getSSID();
            networkPass = "";
            showPasswordDialog(ConnectActivity.this);
            setPasswordListener(new PasswordTypedListener() {

                @Override
                public void onPasswordTyped() {
                    connectHelper = new ConnectHelper();
                    if(scanResult.get(chosenPosition).capabilities.contains("WEP")) {
                        connectHelper.setupConnection(networkSSID, networkPass, "WEP");
                    }
                    //jezeli siec WPA
                    else if(scanResult.get(chosenPosition).capabilities.contains("WPA")) {
                        connectHelper.setupConnection(networkSSID, networkPass, "WPA");
                    }

                    //inne przypadki (open network)
                    else {
                        connectHelper.setupConnection(networkSSID, networkPass, "ELSE");
                    }

                    wifiManager.addNetwork(connectHelper.getConfiguration());

                    List<WifiConfiguration> list = wifiManager.getConfiguredNetworks();
                    for( WifiConfiguration i : list ) {
                        if(i.SSID != null && i.SSID.equals("\"" + networkSSID + "\"")) {
                            wifiManager.disconnect();
                            wifiManager.enableNetwork(i.networkId, true);
                            if(wifiManager.reconnect()) {
                                for(int j=0;j<listWifi.size();j++){
                                    listWifi.get(j).setConnected(false);
                                }
                                runnableCounter=0;
                                handler.postDelayed(ifConnected,1000);
                            }
                            break;
                        }
                    }
                }

            });

        }

    });
}