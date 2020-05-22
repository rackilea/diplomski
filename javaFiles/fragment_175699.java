// Create document
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.newDocument();
    //Create doc type
    DOMImplementation domImpl = doc.getImplementation();
    DocumentType doctype = domImpl.createDocumentType("paymentService", "-//CompanyName//DTD CompanyName PaymentService v2//EN", "http://dtd.CompanyName.com/paymentService_v2.dtd");
    doc.appendChild(doctype);
    // Add root element
    Element rootElement = doc.createElement("root");
    doc.appendChild(rootElement);