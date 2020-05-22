public class Main2Activity extends AppCompatActivity  {

String [] transmitArray;
long transmitFreq;
public static int i;
public static View colourView;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.content_main2);

    colourView = findViewById(R.id.colourBox);
}

final String transmitArray [] = getIntent().getStringArrayExtra("COLOUR_DATA");
    transmitFreq = getIntent().getLongExtra("FREQ_VALUE", 0);
    int arrayLength = transmitArray.length;


 /*
   //Method 1: Using Countdown timer

    new CountDownTimer(transmitFreq*(transmitArray.length), transmitFreq) {

        public void onTick(long millisUntilFinished) {
            colourView.setBackgroundColor(Color.parseColor(transmitArray[i]));
            i++;
        }

        public void onFinish() {
            i=0;
        }
    }.start();

    //Method 2: Using post.delayed

    Handler handler = new Handler();
    for (i = 0; i < arrayLength ; i++) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String transmitColour = transmitArray[i];
                colourView.setBackgroundColor(Color.parseColor(transmitColour));
            }
        }, transmitFreq);
    }*/

    //Method 3: Using thread.sleep

    for (i = 0; i < arrayLength ; i++) {
        String transmitColour = transmitArray[i];
        colourView.setBackgroundColor(Color.parseColor(transmitColour));
        try {
            Thread.sleep(transmitFreq);                
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}