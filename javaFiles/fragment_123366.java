public class MyRequestProcessorFactoryFactory
           extends RequestProcessorFactoryFactory.RequestSpecificProcessorFactoryFactory {
       protected Object getRequestProcessor(Class pClass, XmlRpcRequest pRequest) {
           Object result = super.getRequestProcessor(pClass, pRequest);
           // Configure the object here
           ...
           return result;
       }
   }