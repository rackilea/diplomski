private class SignalStrengthListener extends PhoneStateListener{

    @Override
    public void onSignalStrengthsChanged(SignalStrength signalStrength)
        {
            super.onSignalStrengthsChanged(signalStrength);
            if (telManager.getPhoneType()== TelephonyManager.PHONE_TYPE_CDMA)
                currentSignalStrength = signalStrength.getCdmaDbm();                  
            else
                asu = signalStrength.getGsmSignalStrength();
        }
    }