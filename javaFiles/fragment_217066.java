Document doc = docBuilder.newDocument();
Element rootElement = doc.createElement("Weather");
doc.appendChild(rootElement);

  NodeList weatherNodes = rootElement.getElementsByTagName(strCity);// do we already have node?
  Element weatherElement;
  if(weatherNodes.getLength() > 0){                     // if so reuse
    weatherElement = (Element) weatherNodes.item(0);
}else {                                               // else create
    weatherElement = doc.createElement(strCity);
    rootElement.appendChild(weatherElement);    
}