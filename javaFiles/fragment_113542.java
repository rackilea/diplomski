Document doc = new SAXBuilder().build(Main.class.getResource("/mailtemplate/DefaultMail.html"));

    // XPath that finds the `p` element with id="first"
    XPathExpression<Element> xpe = XPathFactory.instance().compile(
            "//p[@id='first']", Filters.element());
    Element p = xpe.evaluateFirst(doc);

    p.setText("This is my text");

    XMLOutputter xout = new XMLOutputter(Format.getPrettyFormat());
    xout.output(doc, System.out);