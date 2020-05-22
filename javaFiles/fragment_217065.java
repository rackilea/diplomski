Document doc = docBuilder.newDocument();
Element rootElement = doc.createElement("Weather");
doc.appendChild(rootElement);

Element weatherElement = doc.createElement(strCity);
rootElement.appendChild(weatherElement);