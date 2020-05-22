OnStore.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View view) {
        if (OnStore.isChecked()){
            // should do nothing
        } else if (!OnStore.isChecked()){
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