private class surfaceCallback implements SurfaceHolder.Callback
{
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
    {
        if (holder == videoHolder)
        {
            Log.e(TAG, "video surfaceChanged: f: " + format + ", w: " + width + ", h: " + height);

            //resize it here maybe?
        } else
        {
            Log.e(TAG, "Unknown surface: f: " + format + ", w: " + width + ", h: " + height);
            assert (false);
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        Log.e(TAG, "surfaceCreated");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {
        Log.e(TAG, "surfaceDestroyed");
    }
}