@Override
public void onResume()
{
    super.onResume();
    if (!InitDone)
    {
        OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_7, this, mLoaderCallback);
        InitDone = true;
    }
}

private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this)
{
    @Override
    public void onManagerConnected(int status)
    {
        switch (status)
        {
        case LoaderCallbackInterface.SUCCESS:
        {
            Log.i(TAG, "OpenCV loaded successfully");

            // Load native library after(!) OpenCV initialization
             System.loadLibrary("CPlusPlusLibrary");


            // your code here....



            break;              
        }

        default:
        {
            super.onManagerConnected(status);
        }
            break;
        }
    }
};