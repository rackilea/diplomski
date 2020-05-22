package examples.webservices.http_transport_utils;
 import javax.xml.rpc.server.ServiceLifecycle;
import javax.xml.rpc.server.ServletEndpointContext;
import javax.xml.rpc.ServiceException;
 import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 import javax.jws.WebMethod;
import javax.jws.WebService;
 import weblogic.jws.WLHttpTransport;
 import weblogic.wsee.connection.transport.servlet.HttpTransportUtils;
 @WebService(name="HttpTransportUtilsPortType",
            serviceName="HttpTransportUtilsService",
            targetNamespace="http://example.org")
 @WLHttpTransport(contextPath="servlet", serviceUri="HttpTransportUtils",
                 portName="HttpTransportUtilsPort")
 public class HttpTransportUtilsImpl implements ServiceLifecycle {
   private ServletEndpointContext wsctx = null;
   public void init(Object context) throws ServiceException {
    System.out.println("ServletEndpointContext inited...");
    wsctx = (ServletEndpointContext)context;
  }
   public void destroy() {
    System.out.println("ServletEndpointContext destroyed...");
    wsctx = null;
  }
   @WebMethod()
  public String getServletRequestAndResponse() {
     HttpServletRequest request =
       HttpTransportUtils.getHttpServletRequest(wsctx.getMessageContext());
    HttpServletResponse response =
       HttpTransportUtils.getHttpServletResponse(wsctx.getMessageContext());
     System.out.println("HttpTransportUtils API used successfully.");
    return "HttpTransportUtils API used successfully";
   }
 }