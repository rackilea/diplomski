//Root Element
Element root=new Element("CONFIGURATION");
Document doc=new Document();
//Element 1
Element child1=new Element("BROWSER");
//Element 1 Content
child1.addContent("chrome");
//Element 2
Element child2=new Element("BASE");
//Element 2 Content
child2.addContent("http:fut");
//Element 3
Element child3=new Element("EMPLOYEE");
//Element 3 --> In this case this element has another element with Content
child3.addContent(new Element("EMP_NAME").addContent("Anhorn, Irene"));

//Add it in the root Element
root.addContent(child1);
root.addContent(child2);
root.addContent(child3);
//Define root element like root
doc.setRootElement(root);
//Create the XML
XMLOutputter outter=new XMLOutputter();
outter.setFormat(Format.getPrettyFormat());
outter.output(doc, new FileWriter(new File("myxml.xml")));