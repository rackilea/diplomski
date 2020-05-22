new CountDownTimer(40000, 1) {

                public void onTick(long millisUntilFinished) {
                    timer.setText("" + millisUntilFinished / 1000 + ":" + (millisUntilFinished % 1000) / 10 + " sec");
                    timer.setClickable(false);
                }

                public void onFinish() {
                    timer.postDelayed(new Runnable() {
                        public void run() {
                        }
                    }, 1000);
                    timer.setText("Start again");
                    timer.setClickable(true);
                }

            }.start();

        }
    }); // end timer