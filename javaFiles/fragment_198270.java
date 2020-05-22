DocumentBuilder b = ...;

    DOMImplementation impl = b.getDOMImplementation();
    Document d = impl.createDocument(null, "Root", (DocumentType) null);
    Element root = d.getDocumentElement();
    for (int i = 0; i < 5; ++i) {
        Element car = d.createElement("Car");
        // add sub-elements/attributes to car element
        ...
        root.appendChild(car);
    }