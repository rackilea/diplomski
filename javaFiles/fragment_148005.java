public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

  try {

      ...
      if (...) {
        throw new MyTooLargeException();
      } else {
          ...
        res.getWriter().write("ok " + ...);
      }

  } catch (MyTooLargeException e) {
     res.getWriter().write("upload_size_exceeded"); // just an example string 
                                                    // (use your own)

     res.sendError(HttpServletResponse.SC_REQUEST_ENTITY_TOO_LARGE);
  }
}