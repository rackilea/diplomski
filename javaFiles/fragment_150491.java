@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    // TODO Auto-generated method stub
    super.onActivityResult(requestCode, resultCode, data);

    Bitmap bm = (Bitmap) data.getExtras().get("data");
    File imageFile = new File("image.png");
    writeBitmapToMemory(imageFile, bm);
    iv.setImageBitmap(bm);

}

public void writeBitmapToMemory(Filefile, Bitmap bitmap) {
    FileOutputStream fos;

    try {
        // fos = this.openFileOutput(file, Context.MODE_PRIVATE);
        fos = new FileOutputStream(file);
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
        fos.close();

    } 
....