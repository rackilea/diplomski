public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView  sss = (ImageView) findViewById(R.id.sss);
        Button ddd = (Button) findViewById(R.id.button);

        ddd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                 sss.setBackgroundResource(R.drawable.ic_launcher);
            }
        });

    }

}