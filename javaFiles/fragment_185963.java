interface ObjectCreatedFromXmlCallback {
     created(Object object, Element source);
}

// class DocumentParser
public Document parse(Element edoc) {
     doc = new Document();
     doc.objects = ObjectsParser.parse(edoc.getChild("objects"), new ObjectCreatedFromXmlCallback() {
      created(Object o, Element s) {
       if (o instanceof Circle) {
        // read the colour property from s
        doc.objectColours.put(o, colour);
       }
      }
     });

     return doc;
}

// ObjectsParser.parse
c = new Circle();
c.radius = ecircle.getAttribute(...);
callback.created(c, ecircle);