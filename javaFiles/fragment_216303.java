response.setHeader("Content-Disposition","inline, filename=myReport.html");
    response.setContentType("text/html");
    response.setContentLength(bytes.length);
    servletOutputStream.write(bytes, 0, bytes.length);
    servletOutputStream.flush();
    servletOutputStream.close();