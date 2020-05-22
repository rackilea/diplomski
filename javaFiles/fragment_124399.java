import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.util.*;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
public class UploadServlet extends HttpServlet{
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
     throws ServletException, IOException {
   PrintWriter out = response.getWriter();
   out.print("Request content length is " + request.getContentLength() + "<br/>"); 
   out.print("Request content type is " + request.getHeader("Content-Type") + "<br/>");
   boolean isMultipart = ServletFileUpload.isMultipartContent(request);
   if(isMultipart){
              ServletFileUpload upload = new ServletFileUpload();
       try{
              FileItemIterator iter = upload.getItemIterator(request);
              FileItemStream item = null;
              String name = "";
              InputStream stream = null;
              while (iter.hasNext()){
                                     item = iter.next();
                                     name = item.getFieldName();
                                     stream = item.openStream();
                if(item.isFormField()){out.write("Form field " + name + ": " 
                                           + Streams.asString(stream) + "<br/>");}
                else {
                      name = item.getName();
                      if(name != null && !"".equals(name)){
                         String fileName = new File(item.getName()).getName();
                         out.write("Client file: " + item.getName() + " <br/>with file name "
                                                    + fileName + " was uploaded.<br/>");
                         File file = new File(getServletContext().getRealPath("/" + fileName));
                         FileOutputStream fos = new FileOutputStream(file);
                         long fileSize = Streams.copy(stream, fos, true);
                         out.write("Size was " + fileSize + " bytes <br/>");
                         out.write("File Path is " + file.getPath() + "<br/>");
                      }
                   }
              }
          } catch(FileUploadException fue) {out.write("fue!!!!!!!!!");}
   } 
  }
}