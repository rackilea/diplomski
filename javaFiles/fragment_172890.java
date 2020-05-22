public class MainActivity extends Activity {

Set<String> tasks = new HashSet<String>();
final String prefName = "andorid";
SharedPreferences sp;  // you can declare it here

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    sp = getSharedPreferences(prefName, MODE_PRIVATE);  // but don't initialize it until at least here

    SetupApp();
}