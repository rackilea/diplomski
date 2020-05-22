private MatOfPoint2f rectify(MatOfPoint2f approx) {

    DoubleMatrix ndApproxNew, ndAdd, ndApprox;
    Point[] p;
    double [] d;
    MatOfPoint2f hnew;

    ndApproxNew = DoubleMatrix.zeros(4, 2);
    hnew = new MatOfPoint2f();
    //hnew.put(4, 2, ndZeros.data().asFloat());
    //hnew = np.zeros((4, 2), dtype = np.float32);

    //if (!approx.isContinuous()) approx = approx.clone();
    p = approx.toArray();
    Log.d(TAG, "daily - " + p[0].x + " " + p[0].y);
    Log.d(TAG, "daily - " + p[1].x + " " + p[1].y);
    Log.d(TAG, "daily - " + p[2].x + " " + p[2].y);
    Log.d(TAG, "daily - " + p[3].x + " " + p[3].y);