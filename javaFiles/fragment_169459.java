@Override
public void onSensorChanged(SensorEvent event) {
    if (event.values[0] < -100 ||  event.values[1] < -100 || event.values[2] < -100) {
        acceleration.setText("You have X, Y, or Z less than -100");
    }
    else {
        acceleration.setText("X: "+event.values[0]+
            "\nY:"+event.values[1]+
            "\nZ:"+event.values[2]);
    }
}