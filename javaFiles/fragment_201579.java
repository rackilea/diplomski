FileInputStream fis = new FileInputStream(sourcePath);
FileOutputStream fos = new FileOutputStream(destinationPath);
GZIPInputStream gzis = new GZIPInputStream(fis);
byte[] buffer = new byte[1024];
int len = 0;

while ((len = gzis.read(buffer)) > 0) {
    fos.write(buffer, 0, len);
}

fos.close();
fis.close();
gzis.close();