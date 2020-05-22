Mat gray8 = new Mat(marked.size(), CvType.CV_8UC1);
    Imgproc.cvtColor(marked, gray8, Imgproc.COLOR_RGB2GRAY);    
    Scalar mean = Core.mean(gray8);
    Imgproc.threshold(gray8, gray8, mean.val[0], 255,
            Imgproc.THRESH_BINARY);
    /*Imgproc.erode(gray8, gray8, new Mat(), new Point(-1, -1), 2);*/
    List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
    MatOfInt4 hierarchy = new MatOfInt4();
    Imgproc.findContours(gray8, contours, hierarchy,
            Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);
    Toast.makeText(getApplicationContext(), contours.size()+" yo", Toast.LENGTH_SHORT).show();
    for (int contourIdx = 0; contourIdx < contours.size(); contourIdx++) {
        Imgproc.drawContours(orginal, contours, contourIdx, new Scalar(0, 0, 255), -1, 1, hierarchy, 50, new Point(1,1));
    }
    gray8.convertTo(gray8, CvType.CV_32S);
    Imgproc.watershed(orginal, gray8);
    gray8.convertTo(gray8, CvType.CV_8UC1);