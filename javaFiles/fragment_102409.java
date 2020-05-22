NodeList nl = doc.getElementsByTagName("cellimage");
    Element el;
    Integer counter;
    String fName;

    for (int i = 0; i < nl.getLength(); i++) {
        //Not sure what to do here!
        el = (org.w3c.dom.Element) nl.item(i);
        counter = Integer.valueOf(el.getAttribute("counter"));
        fName = el.getAttribute("cash_filename");
    }