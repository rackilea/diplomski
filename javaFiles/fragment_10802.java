@WebServlet(name="CommonRequestHandler", urlPatterns={"/images/*", "/css/*"})
public class CommonRequestHandler extends HttpServlet {

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ServletContext context = getServletContext();
    String path = request.getRequestURI().substring(request.getContextPath().length()+1, request.getRequestURI().length());
    String fileName = context.getRealPath(path);

    //Get MIME type
    String mimeType = context.getMimeType(fileName);
    if(mimeType == null) {
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return;
    }

    //Set content type
    response.setContentType(mimeType);

    //Set content size
    File file = new File(fileName);
    response.setContentLength((int) file.length());

    //Open file and output streams
    FileInputStream in = new FileInputStream(file);
    OutputStream out = response.getOutputStream();

    //Copy file content to output stream
    byte[] buf = new byte[1024];
    int count = 0;
    while((count = in.read(buf)) >= 0) {
        out.write(buf, 0, count);
    }
    in.close();
    out.close();
}
}