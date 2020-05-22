private void enableAccelerometerListening() {
sensorManager = (SensorManager) getSystemService(COntext.SENSOR_SERVICE);
sensorManager.registerListener(sensorEventListener), sensorManager.getDefaultSensor(
Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
}

private void disableAccelerometerListening() {
if (sensorManager != null) {
sesnsorManager.unregisterListener(sensorEVentListener, sensorManager.getDefaultSensor(SensorManager.SENSOR_ACCELEROMETER));
sensorManager = null;
}}