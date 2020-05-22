//Unmarshaller. Step 1 - Decodes Response and set a DOM Node at Owner
//Important. Owner class must not be present in JAXB context, letting next step to decode the object properly. 
//Owner variable at Response class is annotated with @XmlTransient
JAXBContext jaxbContext = JAXBContext.newInstance(Response.class);
Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
Response response = (Response) jaxbUnmarshaller.unmarshal(reader);

//Unmarshaller. Step 2. Convert Node to the suitable Object
//Considering both cases, simple-> String complex -> Owner Object.      
String ownerSimple = ((Node)response.getOwner()).getFirstChild().getNodeValue();
if (ownerSimple != null){
    response.setOwnerSimple(ownerSimple);
} else {
    JAXBContext jaxbContextOwner = JAXBContext.newInstance(Owner.class);
    Unmarshaller  jaxbUnmarshallerOwner = jaxbContextOwner.createUnmarshaller();
    Owner ownerComplex = (Owner) jaxbUnmarshallerOwner.unmarshal((Node)response.getOwner());
    response.setOwnerComplex(ownerComplex);
}

 //Marshaller to system.out. Your object is well mapped in both cases
 Marshaller marshaller = jaxbContext.createMarshaller();
 marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 marshaller.marshal(rx, System.out);