protected void takePicture() {
    if (cameraPreview == null) return;
    Camera camera = cameraPreview.getCamera();
    if (camera == null) return;

    camera.takePicture(null, null, null, new Camera.PictureCallback() {
        public void onPictureTaken(byte[] data, Camera camera) {
            File imageFile = new File(StorageUtils.getStoragePath(CameraActivity.this), StorageUtils.DEFAULT_IMAGE);
            File parentDir = imageFile.getParentFile();
            if(!createImageFromCamera(data, imageFile, parentDir) return;

            //workaround for bug with facing camera introduced (intentionally?) in 4.0+
            boolean requiresImageFlip = isCameraFacingFront && Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH;

            Bitmap adjustedBitmap = getBitmap(imageFile, requiresImageFlip);
            if(!drawWatermark(adjustedBitmap)) return;
            if(!saveImage(imageFile, adjustedBitmap)) return;

            Intent intent = new Intent(CameraActivity.this, ShareActivity.class);
            intent.putExtra(ShareActivity.PARAM_IMAGE_FILE, imageFile.getAbsolutePath());
            if(business != null) intent.putExtra(ShareActivity.PARAM_BUSINESS, business);
            startActivity(intent);
        }
    });
}

private Bitmap getBitmap(File imageFile, boolean flipVertically){
    Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
    Matrix matrix = new Matrix();

    if(flipVertically){
        matrix.setRotate(180);
        matrix.postScale(-1, 1);
    }

    Bitmap adjustedBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
    bitmap.recycle();

    return adjustedBitmap;
}

private boolean saveImage(File imageFile, Bitmap bitmap){
    try {
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(imageFile));
        bitmap.recycle();
        return true;
    } 
    catch (FileNotFoundException e) {
        Log.d(TAG, "Failed to rotate and save bitmap: " + imageFile.getAbsolutePath());
        e.printStackTrace();
        return false;
    }
}

private boolean drawWatermark(Bitmap bitmap){
    try{
        Canvas canvas = new Canvas(bitmap);
        canvas.drawBitmap(watermarkBitmap); // However you're drawing the watermark on the canvas
        return true;
    }
    catch(Exception e){
        e.printStackTrace();
        return false;
    }
}

private boolean createImageFromCamera(byte[] data, File imageFile, File parentDir){
    if (data == null || data.length == 0) return false;

    if (!parentDir.exists()) {
        if (!parentDir.mkdirs()) {
            Log.d(TAG, "Failed to create directory: " + parentDir.getAbsolutePath());
            return false;    
        }        
    }

    try {
        FileOutputStream fos = new FileOutputStream(imageFile);
        fos.write(data);
        fos.close();
    } 
    catch (IOException e) {
        Log.d(TAG, "Failed to save file: " + imageFile.getAbsolutePath());
        e.printStackTrace();
        return false;
    }

    return true;
}