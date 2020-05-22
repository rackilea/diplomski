WifiP2pConfig config = new WifiP2pConfig();
config.deviceAddress = assetWifiP2pDevice.deviceAddress;
config.wps.setup = WpsInfo.KEYPAD;
config.wps.pin = "00000000";
mManager.cancelConnect(mChannel, null);
mManager.connect(mChannel, config, new WifiP2pManager.ActionListener() {
    @Override
    public void onSuccess() {
    }

    @Override
    public void onFailure(int reason) {
    }
});