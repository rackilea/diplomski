ByteArrayOutputStream bytes = new ByteArrayOutputStream();

    //save scaled down image to cache dir
    newBitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

    File imageFile = new File(filePath);

    // write the bytes in file
    FileOutputStream fo = new FileOutputStream(imageFile);
    fo.write(bytes.toByteArray());