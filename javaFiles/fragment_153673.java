public class MainActivity extends Activity {

    CheckBox mCheckBoxRegular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCheckBoxRegular = (CheckBox) findViewById(R.id.checkBox1);

        Button regular = (Button) findViewById(R.id.button1);

        regular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mCheckBoxRegular.setChecked(true);

            }
        });

    }

}