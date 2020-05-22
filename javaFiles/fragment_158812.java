public class CalculatorSoapHandler implements SOAPHandler<SOAPMessageContext>{

   @Override
   public boolean handleMessage(SOAPMessageContext context) {

    Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

    //for response message only, true for outbound messages, false for inbound
    if(!isRequest){

    try{
        SOAPMessage soapMsg = context.getMessage();
        SOAPEnvelope soapEnv = soapMsg.getSOAPPart().getEnvelope();
        SOAPHeader soapHeader = soapEnv.getHeader();

        //process....

        }catch(SOAPException e){
            System.err.println(e);
        }catch(IOException e){
            System.err.println(e);
        }

    }

      //continue other handler chain
      return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
    }

    @Override
    public void close(MessageContext context) {
    }

    @Override
    public Set<QName> getHeaders() {
    }


}