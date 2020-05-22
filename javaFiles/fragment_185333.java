String encoding = "UTF-8"; // Or use a Charset
File file = new File(path, fileName);
BufferedWriter out = new BufferedWriter(
    new OutputStreamWriter(new FileOutputStream(file, true), encoding));
try {
   out.write(...);
} finally {
   out.close()'
}