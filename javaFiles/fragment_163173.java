OnStore.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View view) {
        if (OnStore.isChecked()){
            //
            // set listening flag to true
            //
            isListening = true;
        } else if (!OnStore.isChecked()){
            //
            // set listening flag to false
            //
            isListening = false;
            try {
                for(double TotalAccelerate : list){
                    //System.out.println("final"+ TotalAccelerate);
                    String space = "\n";
                    byte[] convert = space.getBytes();
                    fileOutputStream.write(convert);
                    String finalData;
                    finalData = String.valueOf(TotalAccelerate);
                    fileOutputStream.write(finalData.getBytes());
                    Log.i(DEBUG, "ans: " + finalData);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                Toast.makeText(getApplicationContext(), "Message saving", Toast.LENGTH_LONG).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Toast.makeText(getApplicationContext(),"Message Stopped.",Toast.LENGTH_LONG).show();
        }
    }
});


@Override
public final void onSensorChanged(SensorEvent event) {
    // The light sensor returns a single value.
    // Many sensors return 3 values, one for each axis.
    //
    // regulate
    //
    if (isListening) {
        double xx = event.values[0];
        double yy = event.values[1];
        double zz = event.values[2];
        TotalAccelerate = Math.round(Math.sqrt(Math.pow(xx, 2)
            + Math.pow(yy, 2)
            + Math.pow(zz, 2)));
        Log.i(DEBUG, "Accelerometer = " + TotalAccelerate);

        list.add(TotalAccelerate);
        findPeaks(list);
        sensorText.setText("Total: " + TotalAccelerate);
        Log.i(DEBUG, "list values " + list);
    }
}