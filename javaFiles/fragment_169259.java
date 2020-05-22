FileInputStream in = new FileInputStream("archive.tar.bz2");
FileOutputStream out = new FileOutputStream("archive.tar");
BZip2CompressorInputStream bzIn = new BZip2CompressorInputStream(in);
final byte[] buffer = new byte[buffersize];
int n = 0;
while (-1 != (n = bzIn.read(buffer))) {
  out.write(buffer, 0, n);
}
out.close();
bzIn.close();