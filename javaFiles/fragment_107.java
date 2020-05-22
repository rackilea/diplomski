if(counter>0) {
        toolbar.setBackgroundColor(getResources().getColor(R.color.kartica_trci));
        CountDownTimer secondCountDown = new CountDownTimer(seekBarIntervaliVisokogIntenziteta.getProgress() * 1000 + 100, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                updateTimer((int) millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                textViewTimerVrijeme.setText("00:00");
                karticaTimera.setBackgroundColor(getResources().getColor(R.color.kartica_hodaj));
                imageViewTimerSlika.setImageResource(R.drawable.ic_timer_niski_intenzitet);
                textViewTimerTrciHodajBlaBla.setText(getResources().getString(R.string.timer_hodaj));
                toolbar.setBackgroundColor(getResources().getColor(R.color.kartica_hodaj));
                CountDownTimer thirdCountDown = new CountDownTimer(seekBarIntervaliNiskogIntenziteta.getProgress() * 1000 + 100, 1000) {

                    @Override
                    public void onTick(long millisUntilFinished) {
                        updateTimer((int) millisUntilFinished / 1000);
                    }

                    @Override
                    public void onFinish() {
                        counter--;
                        textViewTimerVrijeme.setText("00:00");
                        countDownTimerTrci();
                    }
                }.start();
            }
        }.start();
    }