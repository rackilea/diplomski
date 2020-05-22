public class MainActivity extends FragmentActivity {

ListenerHandler listenerHandler;

@Override
protected void onCreate(Bundle savedInstanceState) {
    listenerHandler = new ListenerHandler();
}

@Override
protected void onResume() {
    listenerHandler.onResume();
}

    @Override
protected void onPause() {
    listenerHandler.onPause();
}