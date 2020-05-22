//Crear un document XML vacío
DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
dbfac.setNamespaceAware(true);
DocumentBuilder docBuilder;
docBuilder = dbfac.newDocumentBuilder();
DOMImplementation domImpl = docBuilder.getDOMImplementation();
Document doc = domImpl.createDocument("http://cancelacfd.sat.gob.mx", "Cancelacion", null);
doc.setXmlVersion("1.0");
doc.setXmlStandalone(true);

Element cancelacion = doc.getDocumentElement();
cancelacion.setAttributeNS("http://www.w3.org/2000/xmlns/","xmlns:xsd","http://www.w3.org/2001/XMLSchema");
cancelacion.setAttributeNS("http://www.w3.org/2000/xmlns/","xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
cancelacion.setAttribute("RfcEmisor", rfc);
cancelacion.setAttribute("Fecha", fecha);

Element folios = doc.createElement("Folios");
cancelacion.appendChild(folios);
for (int i=0; i<uuid.length; i++) {
    Element u = doc.createElement("UUID");
    u.setTextContent(uuid[i]);
    folios.appendChild(u);
}