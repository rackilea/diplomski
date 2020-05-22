//Check if the requested scheme is http then redirect it to https
if(request.getScheme().equals("http"))
{
    response.sendRedirect("https://www.mysite.com");
}
//If the request is not http but https then collect the data and send to jsp
else
{
        //Collect the data from the database and send it to JSP
        request.setAttribute("data",data);
        RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
    rd.forward(request, response);
}