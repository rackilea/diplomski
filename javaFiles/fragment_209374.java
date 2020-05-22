Object fileid = request.getParameter("fileid");

if(fileid == null)
{
  ReuqestDispatcher dispatcher = request.getRequestDispatcher("whatever.jsp");
  dispatcher.forward(request, response);
}