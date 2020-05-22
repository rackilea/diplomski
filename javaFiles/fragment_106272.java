public void run() {
        int i = 0;
        while(i == 0) {

            try {
                sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (mRecorder != null) {
                amplitude = mRecorder.getMaxAmplitude();

                //Here you can put condition (low/high)
                Log.i("AMPLITUDE", new Integer(amplitude).toString());
            } 

        }
    }