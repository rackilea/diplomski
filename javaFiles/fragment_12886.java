CountDownTimer   timer = new CountDownTimer(1000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                timer.cancel();
                timer = null;
                 startActivity(i);
                overridePendingTransition(R.anim.anim_out, R.anim.anim_in);
                finish();

            }
        };
        timer.start();