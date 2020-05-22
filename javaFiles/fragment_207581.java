InputStream in = null;
OutputStream out = null;

byte[] buffer = new byte[1024];
int length;

try {
  in = new FileInputStream(src);
  out = new FileOutputStream(dest);
  while ((length = in.read(buffer)) > 0) {
    out.write(buffer, 0, length);
  }
} finally {
  if (in != null) {
    try {
      in.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  if (out != null) {
    try {
      out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}