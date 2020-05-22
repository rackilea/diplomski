RectangleList recListInput = new RectangleList();
    RectangleList recListOutput = new RectangleList();
    XStream xstream = new XStream(new DomDriver());
    xstream.alias("list", RectangleList.class);
    xstream.alias("rectangle", Rectangle.class);
    xstream.addImplicitCollection(RectangleList.class, "rectangles");

    ArrayList<Rectangle> rectangleArray = new ArrayList<Rectangle>();
    rectangleArray.add(new Rectangle(18,45,2,6));
    recListInput.setRectangles(rectangleArray);
    String xml = xstream.toXML(rectangleArray);
    System.out.println(xml);
    xstream.fromXML(xml, recListOutput);
    System.out.println("new list size: " + recListOutput.getRectangles().size());