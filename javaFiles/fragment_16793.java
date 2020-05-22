if (!OpenCVLoader.initDebug()) {
    // Handle initialization error
    Log.i(TAG, "OpenCVLoader Failed");
} else {
    Log.i(TAG, "OpenCVLoader Succeeded");

    Log.i(TAG, "Loading opencv_java3...");
    java.lang.System.loadLibrary("opencv_java3");
    Log.i(TAG, "Finished Loading opencv_java3...");
}