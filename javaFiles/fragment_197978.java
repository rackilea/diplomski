@Override
                    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
                        grayMat = inputFrame.gray();
                        double [] grayPixel = grayMat.get(100,100);
                        grayValGlobal = grayPixel[0];
                        Log.i("Mat Value", String.valueOf(grayValGlobal ));
                        return grayMat;
                    }