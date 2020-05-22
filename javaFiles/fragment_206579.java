void doGet(HttpServletRequest req,
                     HttpServletResponse resp)
              throws ServletException,
                     java.io.IOException {

  String param = req.getParameter("name_of_your_param");
  new YourOtherClass().yourOtherMethod(param);
  //implement the rest to return a response
}