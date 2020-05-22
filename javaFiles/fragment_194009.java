protected void doHead(HttpServletRequest req, HttpServletResponse resp)
throws ServletException, IOException
{
   NoBodyResponse response = new NoBodyResponse(resp);
   doGet(req, response);
   response.setContentLength();
}