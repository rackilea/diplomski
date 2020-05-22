import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public FileListServlet() {
        super();
  }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter printWriter = response.getWriter();
        response.setContentType("text/html");

        File currentFolder = new File(".");
        File workingFolder = new File(currentFolder, "Sorted files");

        String root = workingFolder.getAbsolutePath();
        java.io.File dir = new java.io.File(root);

        File[] fileList = dir.listFiles();

        printWriter.println("<H2><FONT COLOR=TEAL>" + "Total number of files in the choosen directory - " +
            fileList.length + "</FONT></H2>");
        printWriter.println("<H3><FONT COLOR=PURPLE>" +
            "Directory path - " + root + "</FONT></H3><HR>");
        printWriter.println("<TABLE BORDER=0 CELLSPACING=5>");



        for(int i = 0; i < fileList.length; i++) {
            printName(fileList[i], printWriter);      
        }
        printWriter.println("</TABLE><HR>");

      }

     private void printName(File file, PrintWriter output)
      {

         System.out.println(file.getName());

        output.println("<tr><td><a href=\"https://Upload/DownloadServlet?name="
                +file.getName()+"\">" + file.getName() + "</a></td></tr>" );

      }

      public String getServletInfo()
      {
        return "This servlet shows a content of a directory" +
               "mentioned in dirToShow parameter or property.";
      }
}