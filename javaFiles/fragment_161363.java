public class MainActivity extends ActionBarActivity {

    Handler mHandler;
    Thread myThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Button1 = (Button) findViewById(R.id.Button1);
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {

                    //your code for what do do with the information coming
                    //from your background thread
                }

                }
                myThread = new Thread(new MyRunnable());
                myThread.start();

            }                
        };


    }


    class MyRunnable implements Runnable {


        @Override
        public void run() {

            Client client = new Client();
            client.   //whatever methods and operations you want to run through
                      //your Client object

            //create a Message object to pass so it is handled by
            //your main thread (presenting retrieved data to the user 
            //for example)
            Message message = mHandler.obtainMessage();

            //when you want to send a Message object back to main
            mHandler.sendMessage(message);


            }

        }
    }