@WebService
public class CalculatorService implements Calculator
{

    @Resource
    private WebServiceContext context;

    @WebMethod
    public void getCounter()
    {
        MessageContext mc = wsContext.getMessageContext();
        // you can grab the HttpSession
        HttpSession session = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST)).getSession();
        // ...or maybe the path info is enough
        String path = mc.get(MessageContext.PATH_INFO);
        // the query itself should almost definitely be enough
        String query = (String) mc.get(MessageContext.QUERY_STRING);
    }

}