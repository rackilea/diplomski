public void doPut(HttpServletRequest request, HttpServletResponse response){
    String filename = (String)request.getHeader("filename");
    StringBuilder fullPath = new StringBuilder(100);
    ServletContext ctxt = getServletContext();
    fullPath.append(ctxt.getRealPath(""))
      .append("uploads\\").append(filename);
    File f = new File(fullPath.toString());
    f.createNewFile();
    InputStream in = request.getInputStream();
    BufferedOutputStream fileOut = 
        new BufferedOutputStream(new FileOutputStream(f));
    byte[] bytes = new byte[BUFFER_SIZE];
    int bytesRead;
    while((bytesRead = in.read(bytes)) != -1){
       fileOut.write(bytes, 0, bytesRead);
    }
    fileOut.flush();
    fileOut.close();
    response.setStatus(HttpServletResponse.SC_CREATED);   
}