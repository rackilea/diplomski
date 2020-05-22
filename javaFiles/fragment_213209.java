class ImgServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imageName = request.getRequestURI();
        InputStream data = service.lookUpImage(imageName); //whatever
        IOUtils.copy(data, response.getOutputStream()); // Apache Commons IO
        response.setContentType("image/jpeg");
    }
}