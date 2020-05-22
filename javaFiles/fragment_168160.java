TransformerFactory factory = TransformerFactory.newInstance();  
Transformer transformer = factory.newTransformer();  
StringWriter writer = new StringWriter();  
Result stringOut = new StreamResult(writer);      
transformer.transform(result, stringOut);  
writer.close();  
System.out.println(writer.toString());