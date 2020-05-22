private void copyDataBase() throws IOException {
    try {
       InputStream mInputStream = mContext.getAssets().open(DB_NAME_ZIP);
       String outFileName = DB_PATH + DB_NAME_ZIP;
       OutputStream mOutputStream = new FileOutputStream(outFileName);
       byte[] buffer = new byte[1024];
       int length;
       while ((length = mInputStream.read(buffer)) > 0) {
          mOutputStream.write(buffer, 0, length);
       }

       ZipFile mZipFile = new ZipFile(DB_PATH + DB_NAME_ZIP);
       InputStream nInputStream = mZipFile.getInputStream(mZipFile.getEntry(DB_NAME));
       OutputStream nOutputStream = new FileOutputStream(DB_PATH + DB_NAME);
       while ((length = nInputStream.read(buffer)) > 0) {
          nOutputStream.write(buffer, 0, length);
       }
       nOutputStream.flush();
       nOutputStream.close();
       nInputStream.close();

       // Close the streams
       mOutputStream.flush();
       mOutputStream.close();
       mInputStream.close();
    } catch (Exception e) {
       e.printStackTrace();
    } finally {
       //Delete Zip file to minimize memory usage
       final String mPath = DB_PATH + DB_NAME_ZIP;
       final File file = new File(mPath);
       if (file.exists())
          file.delete();
    }
}