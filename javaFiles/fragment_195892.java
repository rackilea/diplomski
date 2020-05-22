org.jdom2.Document doc = new SAXBuilder().build(xmlFile);
    Element root = doc.getRootElement();
    Namespace ns = Namespace.getNamespace("http://www.example.com");
    Element type = new Element("type", ns);
    Element prop = new Element("prop", ns);

    // Add <type> as a child of <root>
    root.addContent(type);

    // Set namespace on <type>
    // type.setNamespace(ns); NO NEED, done on new Element("type", ns); above

    type.addContent(new Element("OBJECT_TYPE", ns).setText(objType.getObjectType()));

    // Turn off namespace on <prop>
    // NO!!!! You want to keep the namespace ON!!!
    // prop.setNamespace(Namespace.NO_NAMESPACE);

    // Add <prop> as a child of <type>
    type.addContent(prop);

    prop.addContent(new Element("DESCRIPTION", ns).setText(property.getDescription()));
    prop.addContent(new Element("PARENT", ns).setText(property.getParent()));
    prop.addContent(new Element("VIRTUAL", ns).setText(property.getVirtual()));
    prop.addContent(new Element("VISIBLE", ns).setText(property.getVisible()));
    prop.addContent(new Element("PICTURE", ns).setText(property.getPicture()));
    prop.addContent(new Element("HELP", ns).setText(property.getHelp()));
    prop.addContent(new Element("MIN_NO", ns).setText(property.getMin_no()));
    prop.addContent(new Element("MAX_NO", ns).setText(property.getMax_no()));
    prop.addContent(new Element("NAME_FORMAT", ns).setText(property.getName_format()));

    XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());
    // Create a new file and write XML to it
    xmlOutput.output(doc, new FileOutputStream(new File(XMLEditorService.getXMLEditorService().getFile())));
    System.out.println("Wrote to file");