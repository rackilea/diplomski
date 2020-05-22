//Response
ByteArrayOutputStream baos = new ByteArrayOutputStream();
BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
byte[] buffer = new byte[1024];
int n;
while ((n = in.read(buffer)) > 0) {
    baos.write(buffer,0, n);
}
in.close();
byte[] response = baos.toByteArray();