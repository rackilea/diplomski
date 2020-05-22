public class MainActivity extends AppCompatActivity {
  ConnectivityStatusReceiver connectivityStatusReceiver;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    connectivityStatusReceiver = new ConnectivityStatusReceiver();
  }

  @Override
  protected void onResume() {
    super.onResume();
    IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
    registerReceiver(connectivityStatusReceiver, intentFilter);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    if (connectivityStatusReceiver != null) {
      // unregister receiver
      unregisterReceiver(connectivityStatusReceiver);
    }
  }
}