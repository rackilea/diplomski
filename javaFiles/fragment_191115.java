ByteArrayOutputStream baos = new ByteArrayOutputStream();
byte[] buf = new byte[1024];
int n = 0;
while ((n = myInputStream.read(buf)) >= 0)
    baos.write(buf, 0, n);
byte[] content = baos.toByteArray();

InputStream is1 = new ByteArrayInputStream(content);
... use is1 ...

InputStream is2 = new ByteArrayInputStream(content);
... use is2 ...