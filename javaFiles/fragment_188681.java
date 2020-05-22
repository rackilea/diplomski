String fileName = getFileStreamPath("QRCode.png").getPath();
etSSID.setText(fileName);
OutputStream stream = null;
try {
    stream = openFileOutput("QRCode.png", Context.MODE_WORLD_READABLE);
    bmp.compress(Bitmap.CompressFormat.PNG, 80, stream);
    stream.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}

...

Uri uri = Uri.fromFile(getFileStreamPath("QRCode.png"));
.. share