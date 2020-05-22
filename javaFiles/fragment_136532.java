public void onSensorChanged(SensorEvent event)
    {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            float x = event.values[0]; 
            float y = event.values[1]; 
            float z = event.values[2];
            int YValueMin = 1; 
            int YValueMax = 7;

            accelero.setText("X: " + event.values[0] + "\nY: " + event.values[1] + "\nZ: " + event.values[2]);
            if(y >= YValueMin && y <= YValueMax)
            {
                RepCounter.setText("1");
            }
            else
            {
                RepCounter.setText(" ");
            }
        }
    }