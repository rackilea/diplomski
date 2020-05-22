Result outputResult = new StreamResult(outputStream);
TransformerHandler handler = 
 ((SAXTransformerFactory) transFact).newTransformerHandler(displayTemplate);

Transformer transformer = handler.getTransformer();
// Here is where the parameter is bound.
transformer.setParameter("sessionID", sessionID);

handler.setResult(outputResult);
xmlMarshaller.marshal(listWrapper, handler);