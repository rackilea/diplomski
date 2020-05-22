if ("gzip".equals(httpOpenConnection.getContentEncoding()) {
    is = new GZipInputStream(is);
}
OutputStream os = new FileOutputStream("C:/feed.xml"), "UTF-8")
byte[] buffer = new byte[4096];
int len = 0;
while ((len = is.read(buffer)) > 0) {
    os.write(buffer, 0, len);
}
os.flush();
os.close();