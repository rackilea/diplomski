actviity.runOnUiThread(new Runnable() {
    @Override
    public void run() {
        mSensorView.setReading(val);
    }
});