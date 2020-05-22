URL url = new URL(hRef);
InputStream in = url.openStream();
OutputStream out = new BufferedOutputStream(new FileOutputStream("D:\\foo.zip"));
final int BUFFER_SIZE = 1024 * 4;
byte[] buffer = new byte[BUFFER_SIZE];
BufferedInputStream bis = new BufferedInputStream(in);
int length;
while ( (length = bis.read(buffer)) > 0 ) {
    out.write(buffer, 0, length);
}
out.close();
in.close();