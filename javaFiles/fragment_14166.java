URL url = new URL("http://stackoverflow.com/favicon.ico");
InputStream in = new BufferedInputStream(url.openStream());
OutputStream out = new BufferedOutputStream(new FileOutputStream("D:/favicon.ico"));
for ( int i; (i = in.read()) != -1; ) {
    out.write(i);
}
in.close();
out.close();