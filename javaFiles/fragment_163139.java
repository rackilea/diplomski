public class BeanProcessRPCImpl extends 
                   RemoteServiceServlet implements BeanProcessRPCInterface
{
    private static final long serialVersionUID = 1L;

    public Mybean processMybeanRPC(Mybean  bean)
    {
       //Process your widget  here (CRUD operations)

    }

**you can override doget,doPost,doDelete....etc along with your methods 
}