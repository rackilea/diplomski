SOAPMessage message = smc.getMessage();
SOAPBody body = message.getSOAPBody();

//Then grabbing the first child node of the body and checking its name:
Iterator<Node> nodes = body.getChildElements();
// get the first one
if (n.getNodeName().equals("The node name for the particular operation")) {
 // then we have it
}