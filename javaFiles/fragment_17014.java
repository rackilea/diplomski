//Do the filtering
Mat mask = new Mat(hsv.rows(), hsv.cols(), CvType.CV_8U, new Scalar(0));
Core.inRange(hsv, lower, upper, mask);

// Set to (0,0,0) all pixels that are 0 in the mask, i.e. not in range
Core.bitwise_not( mask, mask);
hsv.setTo(new Scalar(0,0,0), mask);

//Convert back to RGBA (now i use 4 channels since the destination is RGBA)
Imgproc.cvtColor(hsv, rgba, Imgproc.COLOR_HSV2RGB, 4);