@Override
public void setImageBitmap(Bitmap bm) {
    imageRenderedAtLeastOnce = false;
    super.setImageBitmap(bm);
    savePreviousImageValues();
    fitImageToView();
}