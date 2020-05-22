@Override
public void onSensorChanged(SensorEvent sensorEvent) {

    Sensor sensor = sensorEvent.sensor;

    if (sensor.getType() == Sensor.TYPE_LIGHT) {
        lightText.setText("Light = " + sensorEvent.values[0]);

        if(sendData) { // check if we've enabed data sending
            String lightTemp = String.valueOf(sensorEvent.values[0]); // get the sensor value as a string
              sendReceive.write(lightTemp.getBytes()); // send the string over bluetooth
        }

    }
}