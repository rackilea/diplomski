public class MainActivity extends AppCompatActivity {
    Handler h1;
    Thread t;
    EditText editText;
    private Bundle bb = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);

        h1 = new Handler(Looper.getMainLooper()) {

            @Override
            public void handleMessage(Message msg) {
                bb = msg.getData();
                String str = bb.getString("udd");
                editText.setText(str);
                System.out.println(str);
            }
        };
        t = new Thread(new MyRunnable(h1)); //I pass Runnable object in thread so that the code inside the run() method
        //of Runnable object gets executed when I start my thread here. But the code executes in new thread
        t.start(); //thread started

        try {
            t.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}