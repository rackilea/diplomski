public String asString(
                    JAXBContext pContext, 
                    Object pObject)
                        throws 
                            JAXBException {

java.io.StringWriter sw = new StringWriter();

Marshaller marshaller = pContext.createMarshaller();
marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
marshaller.marshal(pObject, sw);

return sw.toString();
 }