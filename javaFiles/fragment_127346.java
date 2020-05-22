finally
{
    request.setAttribute("UserData", lst);
    RequestDispatcher rd=request.getRequestDispatcher("/displayrecord.jsp");
    rd.forward(request, response);
    lst.clear();
    out.close();
}