Chronometer focus = (Chronometer) findViewById(R.id.chronometer1);

startButton.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {

        focus.start();
        setVisibilityTimerOn(); //Second Question Solution
    }
});

stopButton.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {

        focus.stop();
        setVisibilityTimerOff();
    }
});