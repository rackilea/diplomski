private SensorEventListener sensorEventListener = new SensorEventListener() {
    public void onSesnsorChanged(SensorEvent event) {

    float x = event.values[0];
    float y = event.values[1];
    float z = event.values[2];

lastAcceleration = currentAcceleration; //save previous accel value

currentAcceleration = x*x + y*y + z*z;

acceleration = currentAcceleration * (currentAcceleration - lastAcceleration); // calc the change in acceleration

//if the accel is above a certain threshold:
if (acceleration > ACCELERATION_THRESHOLD) {
//MAKE YOUR CODE HERE THAT RESPONDS TO ACCELERATION EVENTS
//Note, your accel threshold should be determined by trial and error on a number of devices
}
}

public void onAccuracyChanged(Sensor sensor, int accuracy {}

};