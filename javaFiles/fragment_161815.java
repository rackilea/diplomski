public static class ScanResultReceiver extends BroadcastReceiver {
   public ScanResultReceiver() {
          //empty constructor
   }

   @Override
    public void onReceive(Context context, Intent intent) {...
      // data here captured fine! 
     // Here I want to send my data to MainActivity Logic(result)
     Logic(result);
    }

    public void Logic(String result){/* ... */}
}