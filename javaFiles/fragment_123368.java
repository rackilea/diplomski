public class MyRequestProcessorFactoryFactory
           extends RequestProcessorFactoryFactory.RequestSpecificProcessorFactoryFactory {
       protected Object getRequestProcessor(Class pClass, XmlRpcRequest pRequest) {
           Object result = super.getRequestProcessor(pClass, pRequest);
           // Configure the object here
           ClassOfObjectBeingExposedViaXmlRpc obj = (ClassOfObjectBeingExposedViaXmlRpc) result;
           XmlRpcHttpRequestConfig httpRequest = (XmlRpcHttpRequestConfig) pRequest.getConfig();
           MyUserClass user = authenticateSomehow(httpRequest.getBasicUserName(), httpRequest.getBasicPassword());
           obj.setUser(user);
           return result;
       }
   }