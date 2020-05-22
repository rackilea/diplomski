DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
Document document = documentBuilder.newDocument();

Element rootNode = document.createElement("root");

Element childNode = document.createElement("child");
childNode.setTextContent("I am a child node");
childNode.setAttribute("attr", "value");

rootNode.appendChild(childNode);
document.appendChild(rootNode);