introImg = (ImageView) findViewById(R.id.introImg);

        final Handler handler = new Handler();
        final int delay1 = 3000; // adjust as needed
        final Handler handler2 = new Handler();
        final int delay2 = 3000; // adjust as needed                        // time here is 0


        handler.postDelayed(new Runnable() {
            public void run() {

                introImg.setImageResource(R.drawable.title);                // time here is 3
                Log.w("myApp","replaced image");

                handler2.postDelayed(new Runnable() {
                    public void run() {

                        setContentView(R.layout.activity_main_menu);        // time here is 6
                        Log.w("myApp","replaced layout");


                    }
                }, delay2);

            }
        }, delay1);