public class FileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Some code before

        FileInputStream in = new FileInputStream(resourceLocation);
        ServletOutputStream out = response.getOutputStream();

        IoUtil.copy(in, out);

        // Some code after
    }
}