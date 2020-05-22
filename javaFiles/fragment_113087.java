public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnToast = (Button) findViewById(R.id.button1);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastMe(v);
            }
        });
    }

    private void toastMe(View v) {
        Toast.makeText(getApplicationContext(), "Test", Toast.LENGTH_SHORT).show();
    }
}