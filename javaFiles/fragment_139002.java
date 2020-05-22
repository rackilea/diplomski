private void cropBorderFromBitmap(Bitmap bmp) {
    int[] pixels;
    //Load the pixel data into the pixels array
    bmp.getPixels(pixels, 0, width, 0, 0, width, height);

    //Convenience variables
    int width = bmp.getWidth();
    int height = bmp.getHeight();
    int length = pixels.length;

    int borderColor = pixels[0];

    //Locate the start of the border
    int borderStart;
    for(int i = 0; i < length; i ++) {
        if(pixels[i] != borderColor) {
            borderStart = i;
            break;
        }
    }

    //Locate the end of the border
    int borderEnd;
    for(int i = length - 1; i >= 0; i --) {
        if(pixels[i] != borderColor) {
            borderEnd = length - i;
            break;
        }
    }

    //Calculate the margins
    int leftMargin = borderStart % width;
    int rightMargin = borderEnd % width;
    int topMargin = borderStart / width;
    int bottomMargin = borderEnd / width;

    //Create the new, cropped version of the Bitmap
    bmp = createBitmap(bmp, leftMargin, topMargin, width - leftMargin - rightMargin, height - topMargin - bottomMargin);
}