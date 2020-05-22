protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // TODO Auto-generated method stub

    String id = request.getParameter("id");
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    try {
        String fileName = Dao.getFileNameWhereId(id);
        if (fileName == null) {
            System.out.println("file name not found!");
            return;
        }

        String resContentType = "APPLICATION/OCTET-STREAM";
        response.setContentType(resContentType);

        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", fileName);
        response.setHeader(headerKey, headerValue);

        InputStream in =  Dao.getTheDbFileInputStreamWhereId(id);

        if (in == null) {
            System.out.println("file not found according to id");
            return;
        }
        for (int i = in.read(); i != -1; i = in.read()) {
            out.write(i);
        }

        in.close();
        out.close();

    } catch (Exception e) {
        System.out.println("problem occurs");
    }

}