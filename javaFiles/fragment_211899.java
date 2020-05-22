private Handler handler = new Handler();

private Runnable runnable = new Runnable() {
    public void run() {
        // roll dice     
    }
};

private final SensorEventListener sensorListener = new SensorEventListener() {

@Override
public void onSensorChanged(SensorEvent sensorEvent) {

    float x = sensorEvent.values[0];
    float y = sensorEvent.values[1];
    float z = sensorEvent.values[2];

    acelLast = acelVal;
    acelVal = (float) Math.sqrt((double) (x*x + y*y + z*z));
    float delta = acelVal - acelLast;
    shake = shake * 0.9f + delta;

    if (shake > 12) {
        try {
            handler.removeCallbacks(runnable);
            handler.postDelayed(runnable, 1000);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

@override
public void onStop() {
    super.onStop();
    handler.removeCallbacks(runnable);
}