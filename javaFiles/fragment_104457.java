XPathFactory xpf = XPathFactory.instance();
XPathExpression<Attribute> xpath = xpf.compile(
            "/Test1/task[@uuid=\"92F7F685-C370-4E55-9026-020E3CDCEDE0\"]/@status",
            Filters.attribute(), null);

Attribute taskStatus = xpath.evaluateFirst(doc);