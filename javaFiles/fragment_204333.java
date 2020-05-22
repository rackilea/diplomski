/*
 * Resizing image size
 */
public static Bitmap decodeFile(String filePath, int WIDTH, int HIGHT) {
    try {

        File f = new File(filePath);

        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(new FileInputStream(f), null, o);

        final int REQUIRED_WIDTH = WIDTH;
        final int REQUIRED_HIGHT = HIGHT;
        int scale = 1;
        while (o.outWidth / scale / 2 >= REQUIRED_WIDTH
                && o.outHeight / scale / 2 >= REQUIRED_HIGHT)
            scale *= 2;

        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize = scale;
        return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    return null;

}

   Bitmap image = decodeFile(_filePaths.get(position), imageWidth, imageHeight);

    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    imageView.setLayoutParams(new GridView.LayoutParams(imageWidth,
            imageWidth));
   imageView.setImageBitmap(image);