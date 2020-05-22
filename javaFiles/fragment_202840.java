SOAPBody body = soapResponse.getSOAPBody();
    if(body.hasFault()){
        LOG.debug("HAS LOG FAULT, LETS SEE WHAT ELSE...");
        LOG.debug("getFaultCode" + body.getFault().getFaultCode());
        LOG.debug("getFaultString" + body.getFault().getFaultString());
    }