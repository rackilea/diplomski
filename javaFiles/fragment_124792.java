[WebMethod]
[ScriptMethod(ResponseFormat = ResponseFormat.Json)]
public User GetUser(string name, int age)
{
    return new User { Name = name, Age = age; }
}