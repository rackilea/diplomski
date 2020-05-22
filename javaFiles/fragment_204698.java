@Override
protected void onPause() {
    super.onPause();
    try {
        if(bitmap != null){
            FileOutputStream fos = openFileOutput("pictures",MODE_PRIVATE);
            bitmap.compress(Bitmap.CompressFormat.JPEG,50,fos);
            fos.close();
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}