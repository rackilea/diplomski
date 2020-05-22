@WebServlet(urlPatterns = { "/UploadServlet" })
@MultipartConfig(location = "/uploads")
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

            PrintWriter out = response.getWriter();

            for (Part part : request.getParts()) {
                String fileName = part.getSubmittedFileName();
                out.println("... writing " + fileName");
                part.write(fileName);
                out.println("... uploaded to: /uploads/" + fileName);
            }

    }
}