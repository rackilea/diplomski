Bitmap bmp = ...; // get your bitmap from Google

String filename = "image.png"
FileOutputStream outputStream;

outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
bmp.compress(CompressFormat.PNG, 75, outputStream);
outputStream.close();