long startTime = 0;
long elapsedTime ;

 b.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        if (b.getText().equals("Stop")) {
            elapsedTime = System.currentTimeMillis() - startTime;
            timerHandler.removeCallbacks(timerRunnable);
            b.setText(R.string.resume);
        } else {
            startTime = System.currentTimeMillis() - elapsedTime;
            timerHandler.postDelayed(timerRunnable, 0);
             Calendar cs = Calendar.getInstance();
            System.out.println("Current time => " + cs.getTime());
            SimpleDateFormat df = new SimpleDateFormat("HH:mm");
            String formattedDate = df.format(cs.getTime());
            timerTextView.setText(formattedDate);
            b.setText(R.string.stop);
        }
    }
});