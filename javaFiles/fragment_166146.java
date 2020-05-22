public static int massageData(File xmlFile, Set<String> xpaths, String mask)
        throws JDOMException, IOException {
    logger.debug("Data massaging started for " + xmlFile.getAbsolutePath());
    int counter = 0;

    Document doc = (Document) new SAXBuilder().build(xmlFile
            .getAbsolutePath());

    for (String xpath : xpaths) {
        logger.debug(xpath);
        XPathExpression<Element> xpathInstance = XPathFactory.instance()
                .compile(xpath, Filters.element());
        List<Element> elements = xpathInstance.evaluate(doc);
        // element = xpathInstance.evaluateFirst(doc);
        if (elements != null) {
            if (elements.size() > 1) {
                logger.warn("Multiple matches were found for " + xpath
                        + " in " + xmlFile.getAbsolutePath()
                        + ". This could be a *potential* error.");
            }
            for (Element element : elements) {
                logger.debug(element.getText());
                element.setText(mask);
                counter++;
            }
        }
    }