public class MainActivity extends Activity {
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
               case 1:
               test((int)msg.obj);
            }
        }
    }

    public void updateUI(final int pass) {
         Message msg = Message.obtain();
         msg.what=1;
         msg.obj = pass;
         mHandler.sendMessage(msg);
    }
}