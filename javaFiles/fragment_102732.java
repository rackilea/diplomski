// your xml document
Document document = ...;

// create a new node to add
Node titleNode = document.createElement("title");
titleNode.setNodeValue("Value to set on the null node");

// The node named "Input Node" in document
Node inputNode = ...;

// append the new node to "Input Node"
inputNode.appendChild(titleNode);