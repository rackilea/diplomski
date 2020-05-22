public void onSensorChanged(SensorEvent event) {
    float x = event.values[0];
    float y = event.values[1];

    textViewX.setText(Float.toString(x));
    textViewY.setText(Float.toString(y));

    Log.i(LOG_TAG, x+","+y);

    if(isConnected && out!=null)
        out.println(String.valueOf(x) + "," + String.valueOf(y));
}