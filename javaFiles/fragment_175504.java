String password=request.getParameter("pwd");
if (password!=null)
{
if(password.equals("servlet"))
    {  
        RequestDispatcher rd=request.getRequestDispatcher("servlet2");  
        rd.forward(request, response);  
    }  
    else
    {  
        errorHandling(request, response);
    }  
}
else
{
    errorHandling(request, response);
}

private void errorHandling(request, response)
{
out.print("Sorry UserName or Password Error!");  
            RequestDispatcher rd=request.getRequestDispatcher("index.html");  
            rd.include(request, response);

}