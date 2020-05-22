Cookie[] cookies = request.getCookies();     // request is an instance of type 
                                             //HttpServletRequest
boolean foundCookie = false;

for(int i = 0; i < cookies.length; i++)
{ 
    Cookie c = cookies[i];
    if (c.getName().equals("userid"))
    {
        string userId= c.getValue();
        foundCookie = true;
    }
}