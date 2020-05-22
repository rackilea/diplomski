String xmlString="<message>....</message>";//above xml code
JAXBContext jc = JAXBContext.newInstance( message.class );
Unmarshaller u = jc.createUnmarshaller();
message o =(message) u.unmarshal( new StreamSource( new StringReader(xmlString ) ) );
System.out.println("------getTo-------"+o.getTo());
System.out.println("------getFrom-------"+o.getFrom());
System.out.println("------getBody-------"+o.getBody()); 
System.out.println("------getThread-------"+o.getThread());