for (int x = 0; x < mRgba.cols(); x++)
{
    for (int y = 0; y < mRgba.rows(); y++)
    {
        double[] rgb = mRgba.get(x, y);
        mGray.put(x, y, Math.min(rgb[0], Math.min(rgb[1], rgb[2])));
    }
}