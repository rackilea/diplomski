public class TestZip02 {

  public static void main(String[] args) {
    try {
      zip(new File("TextFiles.zip"), new File("sample.txt"));
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public static void zip(File zip, File file) throws IOException {
    ZipOutputStream zos = null;
    try {
      String name = file.getName();
      zos = new ZipOutputStream(new FileOutputStream(zip));

  ZipEntry entry = new ZipEntry(name);
  zos.putNextEntry(entry);

  FileInputStream fis = null;
  try {
    fis = new FileInputStream(file);
    byte[] byteBuffer = new byte[1024];
    int bytesRead = -1;
    while ((bytesRead = fis.read(byteBuffer)) != -1) {
      zos.write(byteBuffer, 0, bytesRead);
    }
    zos.flush();
  } finally {
    try {
      fis.close();
    } catch (Exception e) {
    }
  }
  zos.closeEntry();

  zos.flush();
} finally {
  try {
    zos.close();
  } catch (Exception e) {
  }
}