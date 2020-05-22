File oldPath = new File("C:/Temp/old.txt");
File newPath = new File("C:/Temp/new.txt");
long longLength = oldPath.length();
if (longLength > Integer.MAX_VALUE) {
    throw new IllegalArgumentException("File too large: " + oldPath.getPath());
}
int fileSize = (int)longLength;
byte[] bytes = new byte[fileSize];
InputStream in = new FileInputStream(oldPath);
int nread = in.read(bytes);
in.close();
assert nread == fileSize;

String content = "\uFEFF" + new String(bytes, "Windows-1252");
bytes = content.getBytes("UTF-8");

OutputStream out = new FileOutputStream(newPath);
out.write(bytes);
out.close();