final Handler refreshHandler = new Handler();
 Runnable runnable = new Runnable() {
     @Override
     public void run() {
         refreshHandler.postDelayed(this, 2000);
         myfunction();
     }
 };
 refreshHandler.postDelayed(runnable, 2000);


@Override
public void onDestroy () {

    refreshHandler.removeCallback(runnable);
    super.onDestroy ();

}