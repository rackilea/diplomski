Mat roi = new Mat();
roi = mRgba.submat(rect);
Mat roiTmp = roi.clone();

Imgproc.cvtColor(roiTmp, roiTmp, Imgproc.COLOR_RGB2HSV);

Core.inRange(roiTmp, B1, B2, roiTmp);

Imgproc.cvtColor(roiTmp, roi, Imgproc.COLOR_GRAY2BGRA);