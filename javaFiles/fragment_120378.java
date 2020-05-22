public void onSensorChanged(SensorEvent event) {
    switch(event.sensor.getType()) {
        case Sensor.TYPE_MAGNETIC_FIELD:
             System.arraycopy(event.values, 0, m, 0, 3);
             break;
    }
}