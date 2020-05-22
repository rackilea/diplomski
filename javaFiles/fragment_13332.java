package abc.def;

  import java.io.ByteArrayOutputStream;
  import java.io.IOException;
  import java.net.MalformedURLException;

  import org.junit.Test;

  import junit.framework.TestCase;

  public class MainTestCase extends TestCase {
    @Test
    public static void test() throws MalformedURLException, IOException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        JavaSourceViewer.writeURL2Stream("http://www.google.de", baos);
        assertTrue(baos.toString().contains("google"));

    }
  }