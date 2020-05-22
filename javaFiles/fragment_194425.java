public void doGet(HttpServletRequest request,
                  HttpServletResponse response) throws ServletException, 
                                                     IOException {

      OutputStream os = response.getOutputStream();
      String message = UUID.randomUUID().toString();
      os.write(message.getBytes());
  }