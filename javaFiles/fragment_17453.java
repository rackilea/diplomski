public class AnExample {
  public static void main(String... args) throws Throwable {
    final File file = new File("file.txt");
    try (FileOutputStream fos = new FileOutputStream(file);
         OutputStreamWriter out = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {
      out.write("You can read this with a text editor.");
    }
  }
}