@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if(requestCode != 100 || filename == null)
        return;
    bitmap = BitmapFactory.decodeFile(imageUri.getPath()); //set bitmap to your imageview.

}