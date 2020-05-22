@WebService
public class FooService
{
    @WebMethod(operationName = "barMethod")
    public void bar (@WebParam(name = "bazArg") int baz)
    {
        ...
    }
}