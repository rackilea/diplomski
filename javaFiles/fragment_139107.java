public void init() throws ServletException {
    this.filePath = "/files";
}

protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    // Get the file path from the URL.
    String requestedFile = request.getPathInfo();

    //...
    //using filePath attribute in servletclass as the base path
    //to lookup for the files, using the requestedFile
    //path to seek for the existance of the file (by name)
    //in your server
    //decoding the name in case of GET request encoding such as
    //%2F => /
    File file = new File(filePath, URLDecoder.decode(requestedFile, "UTF-8"));
    //...
}