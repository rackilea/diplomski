public class MainScreen extends Activity {

      String[] cityArray = { "Agra ", "Ahmedabad", "Alappuzha", "Amritsar"};
      Spinner list;
      TextView nam;

@Override
protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main_screen);

      list = (Spinner)findViewById(R.id.ListView1);
      nam = (TextView)findViewById(R.id.textView2);