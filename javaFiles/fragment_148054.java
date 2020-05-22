public Bitmap Output(Bitmap takenPhoto, Bitmap frameImage)
{        
    int width, height, x, y;
    height = ### // your desired height of the whole output image 
    width = ### // your desired width of the whole output image
    x = ### // specify indentation for the picture
    y = ###

    Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
    Canvas c = new Canvas(result);
    Paint paint = new Paint();

    c.drawBitmap(takenPhoto, x, y, paint); // draw your photo over canvas, keep indentation in mind (x and y)
    c.drawBitmap(frameImage, 0, 0, paint); // now draw your frame on top of the image

    return result;
}