public class MainActivity extends Activity{
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    SplashHandler handler=new SplashHandler();
    Message msg = new Message();
    msg.what = 0;
    handler.sendMessageDelayed(msg, 3000);

}

private class SplashHandler extends Handler {

            public void handleMessage(Message msg)
              {
                switch (msg.what)
                {
                default:
                case 0:
                  super.handleMessage(msg);

                  Intent intent = new Intent(MainActivity.this,main_window.class);
                  startActivity(intent);
                  MainActivity.this.finish();
                }
              }
        }