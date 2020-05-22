public static Drawable getImageFiltered(Context context, int res, int color) {
    // load image:
    Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), res);
    BitmapDrawable drawable = new BitmapDrawable(context.getResources(), bitmap);

    // create matrix to convert to greyscale:
    ColorMatrix greyscaleMatrix = new ColorMatrix();
    greyscaleMatrix.setSaturation(0);

    // create matrix to colorize and apply transluceny:
    ColorMatrix colorizeMatrix = new ColorMatrix();
    color = context.getResources().getColor(color);
    colorizeMatrix.setScale(Color.red(color) / 255.0f,
            Color.green(color) / 255.0f,
            Color.blue(color) / 255.0f,
            Color.alpha(color) / 255.0f); // <- try setting this to 1.0f for no translucency

    // concatenate the two matrices and create a ColorMatrixColorFilter from the result:
    greyscaleMatrix.postConcat(colorizeMatrix);
    ColorMatrixColorFilter filter = new ColorMatrixColorFilter(greyscaleMatrix);

    // apply the filter:
    drawable.setColorFilter(filter);
    return drawable;
}