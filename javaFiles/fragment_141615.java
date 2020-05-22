@WebServlet("/fotos/*")
public class FotosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletExcpetion, IOException {
        File file = new File("D:/localFilepath", request.getPathInfo().substring(1));
        response.setHeader("Content-Type", getServletContext().getMimeType(file.getName()));
        response.setHeader("Content-Length", String.valueOf(file.length()));
        Files.copy(file.toPath(), response.getOutputStream());
    }

}