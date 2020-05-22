stopButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
       mSensorManager.unregisterListener(this);
    }
});