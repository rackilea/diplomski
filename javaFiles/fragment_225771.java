import java.io.IOException;
import java.util.Properties;

public class TestSO {

  public static void main(String args[]) throws IOException{

      Properties props = new Properties();
      props.setProperty("spring.datasource.password", "$AP=5ttfg{(=<WN");
      props.store(System.out, null);
  }
}