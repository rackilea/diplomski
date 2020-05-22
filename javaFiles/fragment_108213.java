mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
   public void onIabSetupFinished(IabResult result) {
      if (!result.isSuccess()) {
         // Oh noes, there was a problem.
         Log.d(TAG, "Problem setting up In-app Billing: " + result);
      }
         // Hooray, IAB is fully set up!
   }
});