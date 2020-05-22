SOAPHeader soapHeader = context.getMessage().getSOAPHeader();
        Object z;
        XMLUtil xmlUtil = new XMLUtil();
        for( Iterator<SOAPElement> it = soapHeader.getChildElements(new ObjectFactory().createServiceContext(null).getName()); it.hasNext(); ){
            SOAPElement sc = it.next();
            z = xmlUtil.unmarshall(sc, ServiceContextType.class);
        }