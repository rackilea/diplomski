@Override
protected void onPause() {
    super.onPause();
    sensMgr.unregisterListener(grListener);
}

@Override
protected void onResume() {
    super.onResume();
    sensMgr.registerListener(grListener,
            sensMgr.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION),
            SensorManager.SENSOR_DELAY_GAME);
}