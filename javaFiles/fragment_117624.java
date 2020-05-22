/*
* Inner class implementing the input stream used to read a
* (possibly compressed) zip file entry.
*/
private class ZipFileInputStream extends InputStream {

   ...

   public int read(byte b[], int off, int len) throws IOException {
       if (rem == 0) {
           return -1;
       }
       if (len <= 0) {
           return 0;
       }
       if (len > rem) {
           len = (int) rem;
       }
       synchronized (ZipFile.this) {
           ensureOpenOrZipException();