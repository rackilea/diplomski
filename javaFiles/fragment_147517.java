final Button btn1 = (Button) findViewById(R.id.btn1);
    final Button btn2 = (Button) findViewById(R.id.btn2);
    final Button btn3 = (Button) findViewById(R.id.btn3);
    btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            btn2.setClickable(false);
            btn3.setClickable(false);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    btn2.setClickable(true);
                    btn3.setClickable(true);
                }
            }, 5000);
        }
    });