@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final CountDownTimer t;


        t = new CountDownTimer( Long.MAX_VALUE , 1000) {

            int cnt=0;

            @Override
            public void onTick(long millisUntilFinished) {

                cnt++;
                long millis = cnt;
                int seconds = (int) (millis / 60);

                setTime(cnt);
                Log.d("Count:", ""+cnt);
            }

            @Override
            public void onFinish() {
                cnt = 0;
            }

        };

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        snackbar = Snackbar.make(findViewById(R.id.root_layout), "", Snackbar.LENGTH_INDEFINITE);

        final FloatingActionButton fabAdd = (FloatingActionButton) findViewById(R.id.fabAdd);
        final FloatingActionButton fabStop = (FloatingActionButton) findViewById(R.id.fabStop);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.start();
                fabAdd.setVisibility(View.GONE);
                fabStop.setVisibility(View.VISIBLE);
                snackbar.show();
                snackbar.setAction("CANCEL", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t.cancel();
                        t.onFinish();
//                        setTime(0);
                        snackbar.dismiss();
                        fabAdd.setVisibility(View.VISIBLE);
                        fabStop.setVisibility(View.GONE);
                    }
                });

            }
        });

        fabStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.cancel();
                t.onFinish();
//                setTime(0);
                snackbar.dismiss();
                fabStop.setVisibility(View.GONE);
                fabAdd.setVisibility(View.VISIBLE);
            }
        });




    }


    /*
        public void Duration() {
        *//*        Timer timer = new Timer();

            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {

                    runOnUiThread(new Runnable() {
                        int count;

                        @Override
                        public void run() {
                            setTime(count);
                            count++;
                            Log.d("Count:", ""+count);
                        }
                    });
                }
            };*//* //Old code removed on 22Apr17@11:41PM


        }*/ //Old code Duration method

     String display="";

    public void setTime(int rawCount) {

//        int rc = rawCount;

        int minutes = (rawCount - (rawCount % 60)) / 60;
        int seconds = (rawCount % 60);

        String mins = String.format(Locale.ENGLISH, "%02d", minutes);
        String secs = String.format(Locale.ENGLISH, "%02d", seconds);
        display = mins+ ":" +secs;

        Log.d("CountTwo:",display);
        snackbar.setText(display);

    }

    /*public String getTime() {

        Log.d("Count getTime:", display);
        return display;
    }*/