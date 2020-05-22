public void onSensorChanged(SensorEvent event) {
    float x = event.values[0];
    float y = event.values[1];
    if (Math.abs(x) > Math.abs(y)) {
        if (x < 0) {
            image.setImageResource(R.drawable.right);
            textView.setText("You tilt the device right");
        }
        if (x > 0) {
            image.setImageResource(R.drawable.left);
            textView.setText("You tilt the device left");
        }
    } else {
        if (y < 0) {
            image.setImageResource(R.drawable.up);
            textView.setText("You tilt the device up");
        }
        if (y > 0) {
            image.setImageResource(R.drawable.down);
            textView.setText("You tilt the device down");
        }
    }
    if (x > (-2) && x < (2) && y > (-2) && y < (2)) {
        image.setImageResource(R.drawable.center);
        textView.setText("Not tilt device");
    }
}