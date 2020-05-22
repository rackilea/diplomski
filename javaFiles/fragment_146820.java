new CountDownTimer(totalStep * 1000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            step = millisUntilFinished/1000;
            imV.setImageResource(_yourResID);
        }

        @Override
        public void onFinish() {
            Log.d("Finish", "Done");
        }
    }.start();