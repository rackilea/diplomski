public void onButtonClick(View v) {
    Log.d(TAG, "TEST: before");
    myStartService("action1");
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            myStartService("action2");
            Log.d(TAG, "TEST: after");
        }
    }, 3000);
}