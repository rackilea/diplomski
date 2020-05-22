ServiceConnection mServiceConn = new ServiceConnection() {
   public void onServiceDisconnected(ComponentName name) {
       mService = null;
   }

   public void onServiceConnected(ComponentName name, 
      IBinder service) {
       mService = IInAppBillingService.Stub.asInterface(service);
getPurchasedSubs ();
   }

};