public Mat loadImageFromFile(String fileName) {

    Mat rgbLoadedImage = null;

    File root = Environment.getExternalStorageDirectory();
    File file = new File(root, fileName);

    // this should be in BGR format according to the
    // documentation.
    Mat image = Highgui.imread(file.getAbsolutePath());

    if (image.width() > 0) {

        rgbLoadedImage = new Mat(image.size(), image.type());

        Imgproc.cvtColor(image, rgbLoadedImage, Imgproc.COLOR_BGR2RGB);

        if (DEBUG)
            Log.d(TAG, "loadedImage: " + "chans: " + image.channels()
                    + ", (" + image.width() + ", " + image.height() + ")");

        image.release();
        image = null;
    }

    return rgbLoadedImage;

}