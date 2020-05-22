import nu.xom.*;

Builder = new Builder();
Document doc = builder.build(new java.io.StringBufferInputStream(inputXml));
Nodes nodes = doc.query("person");
Element homePhone = new Element("home");
homePhone.addChild(new Text("555-555-5555"));
Element workPhone = new Element("work");
workPhone.addChild(new Text("555-555-5555"));
Element phoneNumbers = new Element("phoneNumbers");
phoneNumbers.addChild(homePhone);
phoneNumbers.addChild(workPhone);
nodes[0].addChild(phoneNumbers);
System.out.println(doc.toXML()); // should print modified xml