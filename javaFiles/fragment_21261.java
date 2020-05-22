XStream xstream = new XStream();

     //converting object to XML
     String xml = xstream.toXML(myObject);

     //converting xml to object
     MyClass myObject = (MyClass)xstream.fromXML(xml);