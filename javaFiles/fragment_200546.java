public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences=getSharedPreferences("File_name",MODE_PRIVATE);

        String data = preferences.getString("key", "");
        view = (TextView)findViewById(R.id.textView3);
        view.setText(data);
    }
}