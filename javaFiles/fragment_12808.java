@Override
public void onBackPressed() {
   // stop Handler
   aHandler.removeCallbacks(r);
   // to stop anonymous runnable use aHandler.removeCallbacksAndMessages(null);
}