private Bitmap _getBitmap(int drawableId, int color) {
    Drawable vectorDrawable;
    if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
        vectorDrawable = getResources().getDrawable(drawableId,null);
    }else {
        vectorDrawable = getResources().getDrawable(drawableId);
    }

    // Wrap the drawable so that future tinting calls work
    // on pre-v21 devices. Always use the returned drawable.
    Drawable wrapDrawable = DrawableCompat.wrap(vectorDrawable);
    DrawableCompat.setTint(wrapDrawable.mutute(), getResources().getColor(color));

    int h = vectorDrawable.getIntrinsicHeight();
    int w = vectorDrawable.getIntrinsicWidth();
    //Setting a pixel default if intrinsic height or width is not found , eg a shape drawable
    h=h>0?h:96;
    w=w>0?w:96;

    wrapDrawable.setBounds(0, 0, w, h);
    Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bm);
    wrapDrawable.draw(canvas);
    return bm;
}