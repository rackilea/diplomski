import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.IOUtils;
@WebServlet("/upload")
public class UploadByteArrayServlet extends HttpServlet {
    private static final long serialVersionUID = 1123445L;
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 1; // 1MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 1; // 1MB
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        byte[] bytes =  "".getBytes();
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if(isMultipart){
            ServletFileUpload upload = new ServletFileUpload();
            upload.setFileSizeMax(MAX_FILE_SIZE);
            upload.setSizeMax(MAX_REQUEST_SIZE);
            try {
                // Parse the request
                FileItemIterator iter = upload.getItemIterator(request);
                while (iter.hasNext()) {
                    FileItemStream item = iter.next();
                    String name = item.getFieldName();
                    InputStream stream = item.openStream();
                    if (item.isFormField()) {
                        System.out.println("Form field " + name + " with value "
                            + Streams.asString(stream) + " detected.");
                    } else {
                        System.out.println("File field " + name + " with file name "
                            + item.getName() + " detected.");
                        //loads only the first file
                        if(bytes.length==0)
                            bytes = IOUtils.toByteArray(item.openStream());
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }       
        } else {
            response.getWriter().print("is not a multipart request");
            response.setStatus(200);
        }
        response.getWriter().print("bytes uploaded in file" + bytes.length);
        //TODO store in session etc...
    }    
}