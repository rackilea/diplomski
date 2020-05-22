// Get entity text
Representation repr = request.getEntity();
String content = repr.getText();

// Use entity text
InputStream inputStream = request.getEntity().getStream();
StringWriter writer = new StringWriter();
IOUtils.copy(inputStream, writer, "UTF-8");

String theString = writer.toString();
JsonRepresentation jRep = new JsonRepresentation(theString);

String token = jRep.getJsonObject().getString("token");

// Set again the entity for the request
StringRepresentation sRepr = new StringRepresentation(
                           content, repr.getMediaType());
request.setEntity(sRepr);