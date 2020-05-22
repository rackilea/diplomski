@Override
public void onResume() {
    super.onResume();
    sensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_FASTEST);

    //Create graph
    GraphView gyroGraph = (GraphView) getView().findViewById(R.id.gyroGraph);

    gyroXSeries = new LineGraphSeries<DataPoint>();
    gyroYSeries = new LineGraphSeries<DataPoint>();
    gyroZSeries = new LineGraphSeries<DataPoint>();

    new GraphHelper(gyroGraph, gyroXSeries, gyroYSeries, gyroZSeries, MAX_POINTS_DISPLAYED);
}