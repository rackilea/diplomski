double maxVal = 0;
int maxValIdx = 0;
for (int contourIdx = 0; contourIdx < contours.size(); contourIdx++)
{
    double contourArea = Imgproc.contourArea(contours.get(contourIdx));
    if (maxVal < contourArea)
    {
        maxVal = contourArea;
        maxValIdx = contourIdx;
    }
}

Imgproc.drawContours(mRgba, contours, maxValIdx, new Scalar(0,255,0), 5);