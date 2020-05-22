TelephonyManager telMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
    int simState = telMgr.getSimState();
            switch (simState) {
                case TelephonyManager.SIM_STATE_ABSENT:
                    // do something
                    break;
                case TelephonyManager.SIM_STATE_NETWORK_LOCKED:
                    // do something
                    break;
                case TelephonyManager.SIM_STATE_PIN_REQUIRED:
                    // do something
                    break;
                case TelephonyManager.SIM_STATE_PUK_REQUIRED:
                    // do something
                    break;
                case TelephonyManager.SIM_STATE_READY:
                    // do something
                    break;
                case TelephonyManager.SIM_STATE_UNKNOWN:
                    // do something
                    break;
            }