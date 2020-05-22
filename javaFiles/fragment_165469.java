@WebMethod
public void throwFault(){
    try {
        SOAPFactory factory = SOAPFactory.newInstance();            
        IndexOutOfBoundsException e = new IndexOutOfBoundsException("index out of bounds");         
        SOAPFault fault = factory.createFault(getStackTraceString(e), new QName("http://whatever.com","CustomFault"));          
        throw new SOAPFaultException(fault);
    } catch (SOAPException e) {
        // ignore for the example           
    }
}

private String getStackTraceString(Exception e){
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    e.printStackTrace(pw);
    return sw.toString();
}