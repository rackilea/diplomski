public void onSensorChanged(SensorEvent event) {
    acceleration.setText("X: " + event.values[0] + 
                        "\nY: " + event.values[1] +
                        "\nZ: " + event.values[2]);

    sm.unregisterListener(this);
}