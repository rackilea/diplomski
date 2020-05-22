try {
    // Create a File Object;
    File file = new File(<file path>)
    // Ensure that the file exists and can be written to;
    if(!file.exists()) {
        file.createNewFile();
    }
    // Create a FileOutputStream Object;
    FileOutputStream fos = new FileOutputStream(file);
    // Write the Bitmap to the File, 100 is max quality but
    //        it is ignored for PNG since that is lossless;
    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos)
    // Clear the output stream;
    fos.flush();
    // Close the output stream;
    fos.close();
} catch (Exception e) {}