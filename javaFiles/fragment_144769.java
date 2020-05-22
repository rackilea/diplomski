private Mat addTo(Mat matA, Mat matB) {
    Mat m = new Mat(matA.rows(), matA.cols() +  matB.cols(), matA.type());
    int aCols = matA.cols();
    int aRows = matA.rows();
    m.rowRange(0, aRows-1).colRange(0, aCols-1) = matA;
    m.rowRange(0, aRows-1).colRange(aCols, (aCols*2)-1) = matB;
    return m;
}