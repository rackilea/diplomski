PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<script type=\"text/javascript\">");
    for (int i = 0; i < urls.length; i++) {
      out.println("window.open(\""+urls[i]+"\");");
    }
    out.println("</script>");
    out.println("</body></html>");
    out.flush();
    out.close();