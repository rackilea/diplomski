public class MainActivity extends Activity {

    CaseWorker worker;


    Button button1;
    Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);

        button1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                worker = new CaseOne();

            }
        });


        button2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                worker = new CaseTwo();

            }
        });

    }

    public void anotherMethod(String[] givenVitals){
       worker.SetVitals(givenVitals);
   }
}