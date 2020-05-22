Paragraph p = new Paragraph("Hello");
doc.add(p);

LayoutArea currentArea = doc.getRenderer().getCurrentArea();
Rectangle rectangle = currentArea.getBBox();
System.out.println(rectangle.getHeight());