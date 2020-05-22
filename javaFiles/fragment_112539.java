DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.parse(f);
doc.getDocumentElement().normalize();

NodeList nList = doc.getElementsByTagName("line");

Element line = (Element) nList.item(0);

Element point1 = (Element) line.getElementsByTagName("point").item(0);
Element point2 = (Element) line.getElementsByTagName("point").item(1);

Integer x1 = Integer.parseInt(point1.getElementsByTagName("X").item(0).getTextContent());
Integer y1 = Integer.parseInt(point1.getElementsByTagName("Y").item(0).getTextContent());
Integer x2 = Integer.parseInt(point2.getElementsByTagName("X").item(0).getTextContent());
Integer y2 = Integer.parseInt(point2.getElementsByTagName("Y").item(0).getTextContent());

System.out.println("x1: " + x1 + "\ty1: " + y1 + "\tx2: " + x2 + "\ty2: " + y2);