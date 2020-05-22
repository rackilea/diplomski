String filename = dis.readUTF();
long fileSize = dis.readLong();
FileOutputStream fos = new FileOutputStream(filename);
while (fileSize > 0 && (n = dis.read(buf, 0, (int)Math.min(buf.length, fileSize))) != -1)
{
  fos.write(buf,0,n);
  fileSize -= n;
}
fos.close();