protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if(resultCode == Activity.RESULT_OK && requestCode == 111){
         String filePath = data.getExtras().getString(ScanConstants.SCANNED_RESULT);
         Bitmap baseBitmap = ScanUtils.decodeBitmapFromFile(filePath, ScanConstants.IMAGE_NAME);
         Log.d("YourTAG","File Path "+filePath);
         // here you can set bitmap to your image view 
         yourImageView.setImageBitmap(baseBitmap);
    }
}