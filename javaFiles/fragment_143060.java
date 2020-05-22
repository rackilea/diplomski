public class LifeCycleActivity extends ActionBarActivity {

private static final String TAG = "lifecycle";
boolean b;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Log.d(TAG,"onCreate");
}

@Override
protected void onStart() {
    super.onStart();
    b = !b;
    Log.d(TAG,"onStart: b = " + b);
}

@Override
protected void onResume() {
    super.onResume();
    Log.d(TAG,"onResume: b = " + b);
}

@Override
protected void onPause() {
    super.onPause();
    Log.d(TAG,"onPause: b = " + b);
}

@Override
protected void onStop() {
    super.onStop();
    Log.d(TAG,"onStop");
}

@Override
protected void onRestart() {
    super.onRestart();
    Log.d(TAG,"onRestart");
}

@Override
protected void onDestroy() {
    super.onDestroy();
    Log.d(TAG,"onDestroy");
}