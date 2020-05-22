public Bitmap takePicture(Camera.PictureCallback pictureCallBack) {
    Camera.Parameters params = camera.getParameters();
    List<Camera.Size> sizes = params.getSupportedPictureSizes();

    List<Integer> list = new ArrayList<Integer>();
    for (Camera.Size size : params.getSupportedPictureSizes()) {
        Log.i("ASDF", "Supported Picture: " + size.width + "x" + size.height);
        list.add(size.height);
    }

    Camera.Size cs = sizes.get(closest(1080, list));
    Log.i("Width x Height", cs.width+"x"+cs.height);
    params.setPictureSize(cs.width, cs.height); //1920, 1080
    camera.setParameters(params);
    camera.takePicture(null, null, pictureCallBack);
}