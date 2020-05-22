ObjectFactory factory = new ObjectFactory();
XhtmlHtmlType html = factory.createXhtmlHtmlType();
XhtmlHeadType head = factory.createXhtmlHeadType();
html.setHead(head);
XhtmlStyleType style = factory.createXhtmlStyleType();
head.getContent().add(factory.createXhtmlHeadTypeStyle(style));