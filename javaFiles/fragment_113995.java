@Override
protected void onDestroy() {
    ((PhotoView)findViewById(R.id.img)).setImageBitmap(null);
    if(bitmap != null) bitmap.recycle();
    super.onDestroy();
}