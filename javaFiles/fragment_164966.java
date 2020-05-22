MatOfPoint approxf1 = new MatOfPoint();
...

Imgproc.approxPolyDP(newMtx, approx, 0.02*peri, true);
approx.convertTo(approxf1, CvType.CV_32S);
List<MatOfPoint> contourTemp = new ArrayList<>();
contourTemp.add(approxf1);
Imgproc.drawContours(img, contourTemp, 0, new Scalar(0, 255, 0), 2);