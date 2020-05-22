import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class Client {


    public void send(File file)
    {
        Socket sc = null;
        try
        {
            byte[] bytearray = new byte[4096];
            sc = new Socket("localhost", 4444);

            // 1. Read the file, send its content, close it. 
            int count;
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            OutputStream os = sc.getOutputStream();

            while((count = bis.read(bytearray))>0)
            {
                os.write(bytearray);
            }
            fis.close();
            sc.shutdownOutput();

            // 2. Delete old file, receive data, write it to new File.
            InputStream is = sc.getInputStream();
            bytearray = new byte[4096];
            // Eventually do what you want with the file: new one, append, etc.
            file.delete();
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            count = 0;
            while((count = is.read(bytearray)) > 0)
            {
                bos.write(bytearray, 0, count);
            }
            fos.close();
            bos.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (sc != null)
            {
                try
                {
                    sc.close();
                } catch (IOException e) {}
            }
        }
    }
}