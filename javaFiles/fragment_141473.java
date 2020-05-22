URLConnection conn = urlNorthView.openConnection();
InputStream in = conn.getInputStream();
String contentType = conn.getHeaderField("Content-Type");
if (!"image/jpeg".equals(contentType)) {
    // hack: assuming it's mime if not a raw image
    int one = in.read();
    if (one == -1) {
        // stop??
    }
    int two = in.read();
    while (two != -1 && !(two == 10 && one == 10)) {
        one = two;
        two = in.read();
    }
}
// if it was mime, we've stripped off the mime headers
// and should now get the image
inputStream2Disk(in);