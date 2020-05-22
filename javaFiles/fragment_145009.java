public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "SUCCESS!";
                Intent intent = new Intent();
                intent.putExtra(MainActivity.STRING_RESULT_DATA_KEY, data);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}