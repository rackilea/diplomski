Visualizer viz = new Visualizer(0);
 viz.setCaptureSize(Visualizer.getCaptureSizeRange()[1]);

        viz.setDataCaptureListener(new OnDataCaptureListener() {

            @Override
            public void onWaveFormDataCapture(Visualizer arg0, byte[] arg1, int arg2) {
                //Wave procesing here

            }
            @Override
            public void onFftDataCapture(Visualizer arg0, byte[] arg1, int arg2) {
                //FFT procesing here!
                }


        }, Visualizer.getMaxCaptureRate(), true, true);
        viz.setEnabled(true);