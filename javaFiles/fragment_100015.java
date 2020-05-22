public void onSensorChanged(SensorEvent sensorEvent) {
    ...
    JSONObject sensorState = new JSONObject();
    sensorState.put("HR",HR_data);
    sensorState.put("Step",Step_Data);
    mSensorBuffArray.put(sensorState);