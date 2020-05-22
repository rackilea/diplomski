byte[] decodedString = Base64.decode(getString(R.string.share_image), Base64.DEFAULT); //The string is named share_image.
Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
Uri imageToShare = Uri.parse(MediaStore.Images.Media.insertImage(MainActivity.this.getContentResolver(), decodedByte, "Share image", null)); //MainActivity.this is the context in my app.
String textToShare = "Sample text"; //Text to be shared

Intent share = new Intent(Intent.ACTION_SEND);
share.setType("image/*");
share.putExtra(Intent.EXTRA_TEXT, textToShare);
share.putExtra(Intent.EXTRA_STREAM, imageToShare);
startActivity(Intent.createChooser(share, "Share with"));