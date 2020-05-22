public void onReceive(Context context, Intent intent) {
        Log.e("DEBUG", "Received");
        try {
            switch(intent.getAction()) {
                case WifiManager.SUPPLICANT_STATE_CHANGED_ACTION:
                    Log.e("Debug", "State changed action");
                    Log.e("Debug", "New state: "+intent.getParcelableExtra(WifiManager
                            .EXTRA_NEW_STATE).toString());
                    if (intent.getIntExtra(WifiManager.EXTRA_SUPPLICANT_ERROR, -1)==WifiManager.ERROR_AUTHENTICATING) {
                        Log.e("Debug", "Error authenticating");
                        if (!SmartWifiChange(false)) { //retry with next available Wifi
                            unregisterReceiver(this);
                            Log.e("AfterError", "Off");
                            stopSelf();
                        }
                    }
                    else if ((intent.getParcelableExtra(WifiManager
                            .EXTRA_NEW_STATE))==SupplicantState.COMPLETED){
                            Log.e("Debug", "Completed");
                        Toast.makeText(context, "Done", Toast.LENGTH_LONG).show();
                        unregisterReceiver(this);
                            Log.e("Completed", "Off");
                        stopSelf();
                    }
                    break;
                default:
                    stopSelf();

            }
        } catch (Exception e) {
            e.printStackTrace();
            unregisterReceiver(this);
            stopSelf();
        }
    }