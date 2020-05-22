// Get the <line> element
NodeList nList = doc.getElementsByTagName("line");
Element line = (Element) nList.item(0);

// Get each <point> element from the <line>
Element point1 = (Element) line.getElementsByTagName("point").item(0);
Element point2 = (Element) line.getElementsByTagName("point").item(1);

// Get each <X> and <Y> from each <point> retrieved before
Integer x1 = Integer.parseInt(point1.getElementsByTagName("X").item(0).getTextContent());
Integer y1 = Integer.parseInt(point1.getElementsByTagName("Y").item(0).getTextContent());
Integer x2 = Integer.parseInt(point2.getElementsByTagName("X").item(0).getTextContent());
Integer y2 = Integer.parseInt(point2.getElementsByTagName("Y").item(0).getTextContent());