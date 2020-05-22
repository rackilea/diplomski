public class Walk
{
  public static void main(String[] args) throws IOException {
    try (PrintWriter writer = new PrintWriter("C:/Users/Joe/Desktop/reports.txt", "UTF-8")) {
      Files.walk(Paths.get("C:/Users/Joe/Desktop/test")).forEach(filePath -> {
        if (Files.isRegularFile(filePath)) {
          writer.println(filePath);
        }
      });
    }
  }
}