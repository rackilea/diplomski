buttonPauseStart.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            buttonPauseStart = (Button) v;
            if (buttonPauseStart.getText().equals("stop")) {
                elapsedTime = System.currentTimeMillis() - startTime;
                timerHandler.removeCallbacks(timerRunnable);
                buttonPauseStart.setText("start");

            } else  {

                startTime = System.currentTimeMillis() - elapsedTime;
                timerHandler.postDelayed(timerRunnable, 0);
                Calendar cs = Calendar.getInstance();
                System.out.println("Current time => " + cs.getTime());

                SimpleDateFormat df = new SimpleDateFormat("HH:mm");
                String formattedDate = df.format(cs.getTime());

                textTimeStarted.setText(formattedDate);
                buttonPauseStart.setText("stop");
            }
        }
    });