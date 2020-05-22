@Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    File xmlFile = new File("someFile.xml"); //Your file location
    long length = xmlFile.length();

    resp.setContentType("application/xml");
    resp.setContentLength((int) length);

    byte[] buffer = new byte[1024];
    ServletOutputStream out = resp.getOutputStream();

    try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(xmlFile))) {
      int bytesRead = 0;
      while ((bytesRead = in.read(buffer)) != -1) {
        out.write(buffer, 0, bytesRead);
      }
    }

    out.flush();
  }