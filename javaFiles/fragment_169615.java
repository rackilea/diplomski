fos = new FileOutputStream(filePath);
while (-1 != (n = in.read(buf))) {
    bytesBuffered += n;
    fos.write(buf, 0, n);
}
fos.flush();