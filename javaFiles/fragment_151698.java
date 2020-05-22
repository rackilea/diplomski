@Override
  public void onServiceConnected(ComponentName arg0, IBinder arg1) {
      service = ISipService.Stub.asInterface(arg1);
      try {
          placeCallWithOption(number);
          // Log.d(THIS_FILE,
          // "Service started get real call info "+callInfo.getCallId());
          Log.e("onservice connected", "on service  connected");
          serviceConnected = true;

      } catch (Exception e) {
          e.printStackTrace();
      }
  }