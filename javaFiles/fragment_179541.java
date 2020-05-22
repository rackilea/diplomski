public class Walk
{
  // Can use Integer.MAX_VALUE for all
  private static final int LEVELS = 2;

  private static final String START_DIR = "C:/Users/Joe/Desktop/test";
  private static final String REPORT_FILE = "C:/Users/Joe/Desktop/reports.txt";

  public static void main(String[] args) {
    try (PrintWriter writer = new PrintWriter(REPORT_FILE, "UTF-8");
         Stream<Path> pathStream = Files.walk(Paths.get(START_DIR), LEVELS)) {

      pathStream.filter(Files::isRegularFile).forEach(writer::println);

    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }
}