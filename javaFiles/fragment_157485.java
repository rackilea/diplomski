SOAPHeader header = request.getSOAPHeader();

Document doc = header.getOwnerDocument();

Element el1 = doc.createElementNS("http://abc.xyz.com/","UserName");
el1.setTextContent("MyName");

Element el2 = doc.createElementNS("http://abc.xyz.com/","Password");
el2.setTextContent("pass******");

Element el0 = doc.createElementNS("http://abc.xyz.com/", "AuthenticationHeader");

el0.appendChild(el1);
el0.appendChild(el2);
header.appendChild(el0);