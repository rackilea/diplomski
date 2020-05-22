@Override
protected void onDestroy() {
    // stop Handler
    aHandler.removeCallbacks(r);
    // to stop anonymous runnable use aHandler.removeCallbacksAndMessages(null);
    super.onDestroy();   
}