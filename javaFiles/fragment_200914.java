[WebMethod(EnableSession = true)]
public bool Login(string login, string password)
{
    // you can use session here so for example log in user
    if(login = "administrator" && password = "secret")
       Session["authorizedUser"] = login;
}