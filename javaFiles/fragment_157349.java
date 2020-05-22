import java.io.File;
  import java.io.FileNotFoundException;
  import java.io.FileOutputStream;
  import java.io.PrintStream;
  import java.text.DateFormat;
  import java.text.SimpleDateFormat;
  import java.util.Date;

  public class So_47900381 {

    static public class Format {
      private static final DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
      PrintStream console = new PrintStream(System.out) {;
        public void println(String x) {
          Date date = new Date();
          super.println("[" + sdf.format(date) + "] " + "program(" + x + ")");
        }
      };
    }

    public static void progStream() throws FileNotFoundException {
      File log = new File("log" + System.currentTimeMillis() + ".txt");
      PrintStream console = new PrintStream(new FileOutputStream(log));
      System.out.println("Writing to " + log.getPath());
      System.setOut(console);
      Format fmt = new Format();
      fmt.console.println("This is a test.");
    }

    public static void main(String[] args) {
      try {
       progStream();
      } catch (Exception x) { x.printStackTrace(); }
    }

  }