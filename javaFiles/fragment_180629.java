@Override
public void onSensorChanged(SensorEvent event) {
    switch (event.sensor.getType()) {
        case Sensor.TYPE_ACCELEROMETER:
            System.arraycopy(event.values, 0, valuesAccel, 0, 3);
            break;

        case Sensor.TYPE_MAGNETIC_FIELD:
            System.arraycopy(event.values, 0, valuesMagnet, 0, 3);
            break;

        case Sensor.TYPE_GRAVITY:
            System.arraycopy(event.values, 0, valuesGravity, 0, 3);
            break;

        default:
            break;
    }

    if (SensorManager.getRotationMatrix(rotationMatrixTemp, null, valuesAccel, valuesMagnet)) {
        SensorManager.getOrientation(rotationMatrixTemp, valuesOrientation);

        if(valuesGravity[2] < 0)                                     {
            if (valuesOrientation[1] > 0) {
                valuesOrientation[1] = (float) (Math.PI - valuesOrientation[1]);
            }
            else {
                valuesOrientation[1] = (float) (-Math.PI - valuesOrientation[1]);
            }
        }

        for (int i = 0; i < valuesOrientation.length; i++) {
            valuesOrientation[i] /= Math.PI;
            valuesOrientation[i] *= 100;
            valuesOrientation[i] = (int)valuesOrientation[i];
            valuesOrientation[i] /= 100;
        }


        updateOrientationBuffer(valuesOrientation);

        quadcopter.onEvent(new Event(Event.Codes.ORIENTATION_CHANGED, calculateSmoothedOrientation()));
    }
    else {
        Log.d("Quadcopter-SM", "Matrix rotate error");
    }
}