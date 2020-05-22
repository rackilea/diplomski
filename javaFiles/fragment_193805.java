String file_path = Environment.getExternalStorageDirectory().getAbsolutePath() + 
                "/MyApp/";

File dir = new File(file_path);
dir.mkdirs();
File file = new File(dir, "myPic.png");
FileOutputStream fOut = new FileOutputStream(file);

screenshot.compress(Bitmap.CompressFormat.PNG, 100, fOut);

fOut.flush();
fOut.close();

// Share
Intent share = new Intent(Intent.ACTION_SEND);
share.setType("image/png");

share.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
share.putExtra(Intent.EXTRA_TEXT, "My Image");

startActivity(Intent.createChooser(share, "Share Image"));