public class Main_Activity extends Activity
{

    Button button;
    MainActivity act;
    MyClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            button = (Button) findViewById(R.id.button1);
            listener = new MyClickListener(this);
            myFunction();
        }

    public void myFunction()
        {
            button.setOnClickListener(listener);
            Log.i("Fun clicked from", "sdfnd");
        }
}