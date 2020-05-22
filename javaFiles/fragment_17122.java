@Override
public boolean handleMessage(SOAPMessageContext context) {
    Boolean outboundProperty = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
    if(outboundProperty.booleanValue()){
        try{
            String authString = parameter.getUser() + ":" + parameter.getPassword();
            SOAPMessage soapMessage =context.getMessage();
            String authorization = new sun.misc.BASE64Encoder().encode(authString.getBytes());
            soapMessage.getMimeHeaders().addHeader("Authorization","Basic " + authorization);   
            soapMessage.saveChanges(); 
        }catch(Exception e){
            log4j.error(e.getMessage(), e);
        }
    }
    return true;
}