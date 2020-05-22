@WebService()
public class SomeWebService {
    ...
    @Resource private WebServiceContext wsc;
    ...
    @WebMethod 
    public void methodOfWebService() {      
        MessageContext mc = wsc.getMessageContext();

        // retrieve the client information
        HttpServletRequest httpServletRequest = 
            (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);    
        System.out.println(httpServletRequest.getServletContext().getContextPath());
        ...
    }
}