wifi=(WifiManager)getActivity().getSystemService(Context.WIFI_SERVICE);
 WifiScanReceiver wifiReciever =  new WifiScanReceiver();

        ToggleButton toggle = (ToggleButton) this.view.findViewById(R.id.toggleButton);

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    getActivity().registerReceiver(wifiReciever, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
                    wifi.startScan();
                } else {
                    wifi.disconnect();
                    getActivity().unregisterReceiver(wifiReciever);
                    // Set your Adapters Here
                }
            }
        });