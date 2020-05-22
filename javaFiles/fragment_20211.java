import java.io.*;
       import java.net.*;

       ...

       try {
            URL fileUrl = new URL("someurl);
            BufferedInputStream in = new BufferedInputStream(fileUrl.openStream());
            FileOutputStream fos = new FileOutputStream("/home/user/download/file");
            BufferedOutputStream bout = new BufferedOutputStream(fos, BUFFER_SIZE);
            byte[] data = new byte[1024];
            int x;

            while ((x = in.read(data, 0, 1024)) >= 0) {
                bout.write(data, 0, x);
            }

            bout.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }