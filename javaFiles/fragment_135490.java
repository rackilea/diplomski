// Creating a DOMSource Object for the request
DocumentBuilder db = DocumentBuilderFactory.newDocumentBuilder();
Document requestDoc = db.newDocument();
Element root = requestDoc.createElementNS("http://org.apache.cxf/stockExample", "getStockPrice");
root.setNodeValue("DOW");
DOMSource request = new DOMSource(requestDoc);