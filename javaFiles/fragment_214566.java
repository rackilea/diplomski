public class MainActivity extends Activity implements OnClickListener
{
    private class Roller implements Runnable
    {
        private int numTimes;
        private long delayMillis;

        public Roller(int numTimes, long delayMillis)
        {
            this.numTimes = numTimes;
            this.delayMillis = delayMillis;
        }

        @Override
        public void run() 
        {
            if (textRoll != null)
            {
                int n = rand.nextInt(100) + 1;
                String roll = String.valueOf(n);
                textRoll.setText("Random number is " + roll);

                numTimes--;

                if (numTimes > 0)
                {
                    textRoll.postDelayed(this, delayMillis);
                }
            }
        }
    }

    private TextView textRoll;
    private Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_roll).setOnClickListener(this);
        textRoll = (TextView)findViewById(R.id.textview_roll);
    }

    @Override
    public void onDestroy()
    {
        findViewById(R.id.button_roll).setOnClickListener(null);
        textRoll = null;
        super.onDestroy();
    }

    @Override
    public void onClick(View v)
    {
        int id = v.getId();

        if (id == R.id.button_roll)
        {
            findViewById(R.id.textview_roll).post(new Roller(20, 100));
        }
    }
}