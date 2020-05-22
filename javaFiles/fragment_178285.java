@WebServlet("/foo.pdf")
public class PdfServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse     response) throws ServletException, IOException {
        byte[] file = getsomehow();
        response.setHeader("Content-Type", "Your staffs content type");
        response.setHeader("Content-Length", file.length);
        response.setHeader("Content-Disposition", "inline; filename=\"something.pdf\"");
        response.getOutputStream().write(file);
        response.getOutputStream().close();
    }

}