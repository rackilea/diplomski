public class MainActivity extends Activity {

    private static final int COUNTDOWN_INTERVAL = 1000;

    MyTimer timer;

    Calendar eventTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File sdcard = Environment.getExternalStorageDirectory();
        File cfgFile = new File(sdcard, "TimeTillParis/config.txt");

        try {
            InputStream is = new FileInputStream(cfgFile);
            Properties prop = new Properties();
            prop.load(is);

            int mmY = Integer.parseInt(prop.getProperty("YEAR"));
            int mmM = Integer.parseInt(prop.getProperty("MONTH"));
            int mmD = Integer.parseInt(prop.getProperty("DAY"));
            int mmH = Integer.parseInt(prop.getProperty("HOUR"));
            int mmC = Integer.parseInt(prop.getProperty("MINUTE"));
            int mmS = Integer.parseInt(prop.getProperty("SECOND"));

            Calendar cal = Calendar.getInstance();

            cal.set(Calendar.YEAR, mmY);
            cal.set(Calendar.MONTH, mmM);
            cal.set(Calendar.DAY_OF_MONTH, mmD);
            cal.set(Calendar.HOUR_OF_DAY, mmH);
            cal.set(Calendar.MINUTE, mmC);
            cal.set(Calendar.SECOND, mmS);

            eventTime = cal;

        } catch (FileNotFoundException e) {
            String cfgNotFound="";
            cfgNotFound += "config.txt not found!";
            TextView textView = (TextView) findViewById(R.id.textView_date_display);
            textView.setText(cfgNotFound);
            //e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(eventTime != null) {
            long millisInFuture = (eventTime.getTimeInMillis() - System.currentTimeMillis());
            timer = new MyTimer(this, millisInFuture, COUNTDOWN_INTERVAL);
            timer.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(timer != null) {
            timer.cancel();
        }
    }

    private static class MyTimer extends CountDownTimer {

        TextView textView;

        public MyTimer(Activity actitivy, long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // findViewById is very expansive, so fined it only once
            textView = (TextView) actitivy.findViewById(R.id.textView_date_display);
        }

        @Override
        public void onFinish() {

        }

        @Override
        public void onTick(long millisUntilFinished) {
            SimpleDateFormat sdf = new SimpleDateFormat("'Next visit to Paris in \n\n'd'd   'h'h   'm'm   's's'");
            String boxText = sdf.format(new Date(millisUntilFinished));

            textView.setText(boxText);
        }

    }
}