public void onSensorChanged(SensorEvent event) {
    int sensor = event.type;
    float[] values = event.values;
    int i;
    StringBuffer str=new StringBuffer();
    // do something with the sensor data
    TextView text = (TextView) findViewById(R.id.my_text);
    float[] R = new float[9]; // rotation matrix
    float[] magnetic = new float[3];
    float[] orientation = new float[3];

    magnetic[0]=0;
    magnetic[1]=1;
    magnetic[2]=0;

    str.append("From Sensor :\n");
    for(i=0;i<values.length; i++) {
        str.append(values[i]);
        str.append(", ");
    }

    SensorManager.getRotationMatrix(R, null, values, magnetic);
    SensorManager.getOrientation(R, orientation);


    str.append("\n\nGives :\n");
    for(i=0;i<orientation.length; i++) {
        str.append(orientation[i]);
        str.append(", ");
    }
    text.setText(str);
}