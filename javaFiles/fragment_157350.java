import java.io.File;
  import java.io.FileNotFoundException;
  import java.io.PrintStream;
  import java.text.DateFormat;
  import java.text.SimpleDateFormat;
  import java.util.Date;

  public class So_47900381_1{

    static public class Format extends PrintStream {
      private static final DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

      public Format(File file) throws FileNotFoundException {
        super(file);
        System.setOut(this);
      }

      public void println(String x) {
        Date date = new Date();
        super.println("[" + sdf.format(date) + "] " + "program(" + x + ")");
      }
    }

    public static void progStream() throws FileNotFoundException {
      File log = new File("log" + System.currentTimeMillis() + ".txt");
      System.out.println("Writing to " + log.getPath());
      Format fmt = new Format(log);          // redirects the output to the file
      System.out.println("This is a test."); // now it's written to the file 
    }

    public static void main(String[] args) {
      try {
        progStream();
      } catch (Exception x) { x.printStackTrace(); }
    }

  }