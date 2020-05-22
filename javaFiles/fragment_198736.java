void END_CALL () throws InvocationTargetException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException {

    tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
      Class c = null;
      try {
          c = Class.forName(tm.getClass().getName());
      } catch (ClassNotFoundException e) {
          e.printStackTrace();
      }
      Method m = null;
      try {
          m = c.getDeclaredMethod("getITelephony");
      } catch (NoSuchMethodException e) {
          e.printStackTrace();
      }
      m.setAccessible(true);
    Object telephonyService = m.invoke(tm); // Get the internal ITelephony object
    c = Class.forName(telephonyService.getClass().getName()); // Get its class
    m = c.getDeclaredMethod("endCall"); // Get the "endCall()" method
    m.setAccessible(true); // Make it accessible
    m.invoke(telephonyService); // invoke endCall()

      if ( SIGNAL_STOP == false ) {
          timerHandlerServicesStartNewNumber.postDelayed(timerRunnableServicesStartNewNumber, 1000);
      }

}


  private class PhoneStateChangeListener extends PhoneStateListener {

        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            switch(state){
                case TelephonyManager.CALL_STATE_RINGING:
                    Log.println( Log.INFO , "RINGING" , "SERVICES%%%%%%%%%%%%%%%%RINGING%%%%%%%%%%%%%%%%%%");
                    wasRinging = true;
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    Log.println( Log.INFO , "OFFHOOK BROADCAST" , "SERVICES%%%%%%%%%%%%%%%%%%%%%%%%");

                    if (!wasRinging) {
                        // Start your new activity
                        Log.println( Log.INFO , "OFFHOOK BROADCAST" , "SERVICES%%%%%%%%%%%%%%%%%%%%%%%");

                      if (SIGNAL_STOP == false) {
                          timerHandlerServices.postDelayed(timerRunnableServices, 10000);

                      }


                    } else {
                        // Cancel your old activity
                        Log.println( Log.INFO , "OFFHOOK BROADCAST" , "SERVICES%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                    }

                    // this should be the last piece of code before the break
                    wasRinging = true;
                    break;
                case TelephonyManager.CALL_STATE_IDLE:
                    Log.println( Log.INFO , "IDLE BROADCAST" , "SERVICES%%%%%%%%%%%%%%%%%IDLE%%%%%%%%%%%%%%%%%%%");

                    // this should be the last piece of code before the break
                    wasRinging = false;
                    break;
            }
        }
    }