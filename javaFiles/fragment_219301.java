FileOutputStream outputStream = null;
  try {
 outputStream = openFileOutput("filename.jpg", Context.MODE_PRIVATE);
 // Use the compress method on the BitMap object to write image to the OutputStream
 bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }