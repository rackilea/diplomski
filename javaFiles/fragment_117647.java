@Resource
WebServiceContext wsContext;

@WebMethod
public String myServiceOperation(){
MessageContext context = wsContext.getMessageContext();
HttpServletRequest res = (HttpServletRequest) context.get(MessageContext.SERVLET_REQUEST) ;
System.out.println(" Context:path "+res.getContextPath());
}