private Bitmap getBitmapFromLayout(int layout) {

    LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View view = layoutInflater.inflate(layout, null);

    view.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), 
        MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
    view.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());

    view.buildDrawingCache();

    Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(),
            Bitmap.Config.ARGB_8888);

    Canvas canvas = new Canvas(bitmap);
    canvas.drawColor(Color.WHITE, PorterDuff.Mode.SRC_IN);

    Drawable drawable = view.getBackground();
    if (drawable != null)
        drawable.draw(canvas);

    view.draw(canvas);

    return bitmap;
}