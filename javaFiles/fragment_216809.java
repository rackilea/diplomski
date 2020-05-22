URL url = new URL("http://www.evemarketeer.com/api/orders/10000043/30119/xml");
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder db = dbf.newDocumentBuilder();
Document doc = db.parse(url.openStream());
NodeList nodes = doc.getElementsByTagName("row");
System.out.println(nodes.getLength() + " nodes found");