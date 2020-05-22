accelBuffer = new StringBuilder();
accelBuffer.append(LAST_TS_ACC + "," + event.values[0] + "," + event.values[1] + "," + event.values[2] + "\n");

if((accelBuffer.length() > 500000) && (writingAccelToFile == false) ){
                writingAccelToFile = true;

                AccelFile = new File(path2 +"/Acc/"  + LAST_TS_ACC +"_Service.txt");
                Log.d(TAG, "onSensorChanged: accelfile created at : " + AccelFile.getPath());

                File parent = AccelFile.getParentFile();
                if(!parent.exists() && !parent.mkdirs()){
                    throw new IllegalStateException("Couldn't create directory: " + parent);
                }

                //Try threading to take of UI thread

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //Log.d(TAG, "onSensorChanged: in accelbuffer");
                        // Log.d(TAG, "run: in runnable");
                        //writeToStream(accelBuffer);
                        writeStringBuilderToFile(AccelFile, accelBuffer);
                        accelBuffer.setLength(0);
                        writingAccelToFile = false;

                    }
                }).start();

            }