public class MainActivity extends AppCompatActivity {

public static final String MyPREFERENCES = "MyPrefs" ;
public static int demodays = 0;
public static int finishdate = 0;
SharedPreferences sharedpreferences;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (demodays == 0){
        DateFormat df = new SimpleDateFormat("D");
        String data = df.format(Calendar.getInstance().getTime());
        demodays = Integer.parseInt(data);
        finishdate = demodays + 30;

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt("data", demodays);
        editor.putInt("finishdata", finishdate);
        editor.apply();
    }

    DateFormat df = new SimpleDateFormat("D");
    String today = df.format(Calendar.getInstance().getTime());
    int today1 = Integer.parseInt(today);

    if (today1 == finishdate) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Period of trial has finished", Toast.LENGTH_SHORT);
        toast.show();
        this.finish();
    }
}
}