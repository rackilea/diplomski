if (registerSucces) 
{
    SendMail.send();
    rd = request.getRequestDispatcher("loginpage.jsp");
} 
else 
{
    rd = request.getRequestDispatcher("registerpage.jsp");
}
rd.forward(request, response);