Button b = (Button) findViewById(R.id.button1);
    final TextView tv = (TextView) findViewById(R.id.tv_1);

    b.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            new CountDownTimer(45 * 1000, 1000) {
                int x = 45;

                @Override
                public void onTick(long millisUntilFinished) {
                    tv.setText(Integer.toString(x));
                    x--;

                }

                @Override
                public void onFinish() {
                    tv.setText("0");

                }
            }.start();

        }
    });