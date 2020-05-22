public class Main2Activity extends AppCompatActivity {

    TextView mTextField;
    Button stop;
    Activity myActivity;
    PrimeThread T1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myActivity=this;
        mTextField = (TextView) findViewById(R.id.counter);
        T1=new PrimeThread();
        T1.start(); }

    public void stop(View view){   T1.stopRunning();    }

    class PrimeThread extends Thread {
        int i=10;
        boolean running = false;
        public void run() {
            running = true;
            while(running && i < 10){
                i++;
                myActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTextField.setText("00:0"+i);
                    }
                });
                i--;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void stopRunning(){
            running = false;
        }
    }
}