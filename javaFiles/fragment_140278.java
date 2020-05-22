public boolean storeImages(Bitmap imageBitmap, String fileName, String dirName, int index) {
    File file;
    if (isExternalStorageWritable() && isExternalStorageReadable()) {
        file = storeImageExternalMemory(dirName, albumName, String.valueOf(index));
    }
    try {
        assert file != null;
        FileOutputStream out = new FileOutputStream(file);
        imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
        out.flush();
        out.close();
        updateImageTable(file, index);  // Implement Your own method to update ur DB table, U can access file location from DB table for future use of images
        return true;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}