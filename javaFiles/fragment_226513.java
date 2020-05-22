boolean success = false;

// Encode the file as a PNG image.
FileOutputStream outStream;
try {

    outStream = new FileOutputStream(image);
    bitmap.compress(Bitmap.CompressFormat.PNG, 100, outStream); 
    /* 100 to keep full quality of the image */

    outStream.flush();
    outStream.close();
    success = true;
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}