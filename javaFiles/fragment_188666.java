public class MainActivity extends Activity {

    RadioButton rb1, rb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb3 = (RadioButton) findViewById(R.id.rb3);

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCustomClick(v);
            }
        });
    }

    public void onCustomClick(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        if (rb1.isChecked() && rb3.isChecked())
            Toast.makeText(getApplicationContext(), "1 and 3 selected",
                    Toast.LENGTH_SHORT).show();

    }
}