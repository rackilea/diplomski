// String username created from edit text field to a string
String username = mpic.getText().toString(); 
// Bitmap will decode the string to a image (bitmap)
Bitmap myBitmap = BitmapFactory.decodeFile(username);
// Image view used to set the bitmap
ImageView myImage = (ImageView) findViewById(R.id.photoResultView);
// Setting the image to the image view
myImage.setImageBitmap(myBitmap);