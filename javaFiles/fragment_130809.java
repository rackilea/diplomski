public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws javax.servlet.ServletException, java.io.IOException
    {
        PrintWriter writer = response.getWriter();

        // foo.txt is at the root directory of the web app
        InputStream in = getServletContext().getResourceAsStream("/foo.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String text;
        while ((text = reader.readLine()) != null) {
            writer.println(text);
        }
    }    
}