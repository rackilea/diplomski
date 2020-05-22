InputStream is = new FileInputStream(someFile);
try {
   // do some work
   ...
} finally {
   is.close();
}