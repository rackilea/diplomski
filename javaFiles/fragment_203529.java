DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

Document doc = docBuilder.newDocument();

//Create the root Customers element
Element rootElement = doc.createElement("Customers");
doc.appendChild(rootElement);

//Create Marker element
Element markerElement = doc.createElement("Marker");
markerElement.setAttribute("category","Production");
rootElement.appendChild(markerElement);