private static Bitmap reversColors(Bitmap b){

    int width = b.getWidth();
    int height = b.getHeight();

    int[] pixels = new int[width * height];
    b.getPixels(pixels, 0, width, 0, 0, width, height);

    int[] finalArray = new int[width * height];

    for(int i = 0; i < finalArray.length; i++) {
        int red = Color.red(pixels[i]);
        int green = Color.green(pixels[i]);
        int blue = Color.blue(pixels[i]);
        int alpha = Color.alpha(pixels[i]);
        finalArray[i] = Color.argb(alpha, blue, green, red);
    }

    return Bitmap.createBitmap(finalArray, width, height, Bitmap.Config.ARGB_8888);

}