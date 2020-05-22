//append new user
Element users = xmlDoc.getDocumentElement();

Element newUser = xmlDoc.createElement("user");

Element newUsername = xmlDoc.createElement("username");
Element newPassword = xmlDoc.createElement("password");

newUsername.appendChild(xmlDoc.createTextNode(email));
newPassword.appendChild(xmlDoc.createTextNode(password));

newUser.appendChild(newUsername);
newUser.appendChild(newPassword);

users.appendChild(newUser);

//save to file
DOMSource source = new DOMSource(xmlDoc);
TransformerFactory transformerFactory = TransformerFactory.newInstance();
Transformer transformer = transformerFactory.newTransformer();
StreamResult result = new StreamResult(openFileOutput(xmlFileName, Context.MODE_PRIVATE)); 
transformer.transform(source, result);