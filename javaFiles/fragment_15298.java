import nu.xom.*;

    List<Element> cds = new Builder().build(inputFile).getRootElement().query("CD");
    for (Element e : cds) {
        System.out.println(e.getFirstChildElement("ARTIST").getValue() 
            + " recorded " 
            + e.getFirstChildElement("TITLE").getValue() 
            + " in " 
            + e.getFirstChildElement("YEAR").getValue());
    }