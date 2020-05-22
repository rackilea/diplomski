BitmapDrawable bm = (BitmapDrawable) yourImageView.getDrawable();
Bitmap mysharebmp = bm.getBitmap();
String path = Images.Media.insertImage(getContentResolver(),
                    mysharebmp, "MyImage", null);
Uri uri = Uri.parse(path);
Intent sharingIntent = new Intent(Intent.ACTION_SEND);
sharingIntent.setType("image/png");
sharingIntent.putExtra(Intent.EXTRA_STREAM, uri);
startActivity(Intent.createChooser(sharingIntent,
                    "Share image using"));