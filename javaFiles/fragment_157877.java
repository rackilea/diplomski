package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class StreamServlet extends HttpServlet {
    private static final String WINDOWS_UPLOAD_DIR = "C:\\Projects\\Data\\img";

    /**
     * Serve the images from the specified dir.
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
              throws ServletException, IOException {

        String fileName = req.getPathInfo().substring(1);
        File imageFile = new File(WINDOWS_UPLOAD_DIR, fileName);

        OutputStream os = resp.getOutputStream();
        InputStream is = new FileInputStream(imageFile);

        IOBridge(is, os);
        os.flush();
        Close(is, os);
    }

    /**
     * Bridge data between an input and output stream.
     *
     * @param in  The input stream.
     * @param out The output stream
     * @throws IOException if there's an error.
     */
     private static void IOBridge(InputStream in, OutputStream out) 
             throws IOException {

         byte data[] = new byte[1024];
         int readCount = 0;
         while ((readCount = in.read(data, 0, readCount)) != -1) {
             out.write(data);
         }
      }

     /**
      * Close some closeables
      *
      * @param closeables The closeables to be closed.
      */
     private static void Close(Closeable... closeables) {
          for (Closeable c : closeables)
              if (c != null)
                  try {
                      c.close();
                  } catch (IOException ioe) {
                      try {
                          c.close();
                      } catch (Exception e) {
                          e.printStackTrace();
                      }

                  } finally {
                        try { 
                             c.close();
                        } catch (Exception e) {
                             e.printStackTrace();
                        }
                 }
         }
    }