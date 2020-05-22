public void onPictureTaken(byte[] data, Camera camera) {
    //.../
    Bitmap imagemOriginal = BitmapFactory.decodeByteArray(data, 0, data.length); // 2560×1440
    float scale = 1280/1000F;
    int left = (int) scale*(imagemOriginal.getWidth()-400)/2;
    int top = (int) scale*(imagemOriginal.getHeight()-616)/2;
    int width = (int) scale*400;
    int height = (int) scale*616;
    Matrix rotationMatrix = new Matrix();
    rotationMatrix.postRotate(90);
    Bitmap imagemCortada = Bitmap.createBitmap(imagemOriginal, left, top, width, height, rotationMatrix, false);
    //.../
}