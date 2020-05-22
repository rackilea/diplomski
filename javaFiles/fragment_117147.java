class MyActivity extends Activity {
        private BroadcastReceiver myReceiver = new BroadcastReceiver() {
            @Override
             public void onReceive(final Context context, final Intent intent) {
                MyActivity.this.onMessageReceived();
             }
        }
        @Override
        protected void onResume() {
            registerReceiver(myReceiver, new IntentFilter("com.foo.ACTION"));
        }

        @Override
        protected void onPause() {
            unregisterReceiver(myReceiver);
        }

        private void onMessageReceived() {
        }
    }