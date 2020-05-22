Uri uri = null;

protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
    super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        if(resultCode == RESULT_OK){
            Uri selectedImage = imageReturnedIntent.getData();
            uri  = selectedImage; // here set the uri 
            String PathP = selectedImage.getPath().toString();
            FilePathPreview.setText(PathP);
        }
}