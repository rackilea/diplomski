private boolean isFirstMeasure = true;
private float firstAzimuthValue = 0;

// ...

@Override
public void onSensorChanged(SensorEvent event) {
    if (isFirstMeasure) {
        firstAzimuthValue = event.values[0];
        isFirstMeasure = false;
    }

    rotationx.setText(" " + (event.values[0] - firstAzimuthValue));
    rotationy.setText(" " +event.values[1]);
    rotationz.setText(" " +event.values[2]);
}