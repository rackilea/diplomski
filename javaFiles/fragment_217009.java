@Override
public void onSensorChanged(SensorEvent event) {
    float xValue = event.values[0];
    float yValue = event.values[1];
    float zValue = event.values[2];
    Log.d(LOG_TAG, "x:"+xValue +";y:"+yValue+";z:"+zValue);
}