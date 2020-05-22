public class AnExample {
  public static void main(String... args) throws Throwable {
    final File file = new File("file.dat");
    try (FileOutputStream fos = new FileOutputStream(file);
         DataOutputStream out = new DataOutputStream(fos)) {
      out.writeInt(42);
    }
  }
}