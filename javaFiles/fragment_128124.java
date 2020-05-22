public boolean handleMessage(SoapMessageContext context){
......
......
SOAPBody soapbody=context.getMessage().getSOAPBody();

    Iterator itr=soapbody.getChildElements();

    while(itr.hasNext()){


    SOAPElement se=(SOAPElement)itr.next();


    System.out.println("Requsted class name "+se.getElementName().getLocalName());

    }
....

// proces the handler based on your class name

}