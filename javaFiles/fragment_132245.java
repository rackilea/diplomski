XMLOutputFactory xof = XMLOutputFactory.newFactory();
    XMLStreamWriter xsw = xof.createXMLStreamWriter(System.out);
    xsw.writeDTD("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");

    Marshaller marshaller = jc.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
    marshaller.marshal(html, xsw);
    xsw.close();