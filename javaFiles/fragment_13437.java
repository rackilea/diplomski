@WebServlet(name="myAwesomeServlet", urlPatterns={"/filedl"})
public class MyAwesomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fileName = (String) request.getParameter("file");
        FileInputStream fis = null;

        try {

            fis = new FileInputStream(fileName);
            response.setContentType("application/octet-stream"); 

            OutputStream out = response.getOutputStream();
            IOUtils.copy(fis, out); // this is using apache-commons, 
                                    // make sure you provide required JARs

        } finally {            

            IOUtils.closeQuietly(out);  // this is using apache-commons, 
            IOUtils.closeQuietly(fis);  // make sure you provide required JARs

        }

    }
}