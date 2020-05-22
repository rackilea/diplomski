public boolean handleMessage(SOAPMessageContext mc) {
...
ByteArrayOutputStream out = new ByteArrayOutputStream();
SOAPMessage soapMsg = mc.getMessage();

mc.put("soapMsg", out); 
mc.setScope("soapMsg", MessageContext.Scope.APPLICATION);  
...
}