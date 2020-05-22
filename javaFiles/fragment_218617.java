package my.super.interceptor;

public final class Suppressor extends AbstractSoapInterceptor {

   public Suppressor() { super(Phase.SETUP); }

   @Override
   public void handleMessage(final SoapMessage message) throws Fault        
   {                       

     final boolean suppressResponse = this.suppressResponse(message);

     if(suppressResponse) {
         log.debug("-> Suppressing response");
         message.getInterceptorChain().abort();
     }

   //if you want to suppress both responses and faults, you need
   //to check them separately. 
   //Change this code to check headers for whatever criteria you want
   //(Note you may need to change the super(Phase...) )
   //The code's a bit messy here - just sketching out the idea for the answer
   private boolean suppressResponse(final Message message) {            
     final Fault fault = (Fault)message.getContent(Exception.class);

     if(fault != null) {
        final String faultMessage = fault.getMessage();

         return faultMessage.indexOf("Something-you-want-to-match") > 0;

     } else {
        final MessageInfo messageInfo = (MessageInfo)message.get("org.apache.cxf.service.model.MessageInfo");            
        final String operation = messageInfo.getOperation().getOutputName();            

        return operation.indexOf("Something-you-want-to-match") > 0;
     }
   }