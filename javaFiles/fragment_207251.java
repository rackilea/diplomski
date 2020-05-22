@POST
    @Path("/post-vendor-data")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_JSON)
    public void createThisObject(@Valid VendorObject obj) throws IOException, ServletException {
        RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
        request.setAttribute("myObject", obj);
        view.forward(request, response);
    }