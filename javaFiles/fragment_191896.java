public class MainActivity extends Activity {

    ImageButton imagebutton;
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagebutton = (ImageButton) findViewById(R.id.button1);
        button = (Button) findViewById(R.id.button2);


        imagebutton.setOnClickListener(new OnClickListener() {
            public void onClick (View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.30F8.com/"));
                startActivity(i);;

            }
        });

        button.setOnClickListener(new OnClickListener() {
            public void onClick (View v) {
              Intent i = new Intent(MainActivity.this, SecondActivity.class);
              startActivity(i);

            }
        });
    }
}