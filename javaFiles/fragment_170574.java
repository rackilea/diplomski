package stack.overflow;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Testing {
    public static void main(String[] args) {
         URL url = null;
        try {
            url = new URL("https://www.mannschaftsfoto-nrw.de/rpc/captcha/Ddc3Lp5eOshwmzWfpgL4cNCTnZTcOU2T");
          InputStream in = new BufferedInputStream(url.openStream());
          ByteArrayOutputStream out = new ByteArrayOutputStream();
          byte[] buf = new byte[1024];
          int n = 0;
          while (-1!=(n=in.read(buf)))
          {
            out.write(buf, 0, n);
          }
          out.close();
          in.close();
          byte[] response = out.toByteArray();
          FileOutputStream fos = new FileOutputStream("C://captcha.jpg");
          fos.write(response);
          fos.close();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}