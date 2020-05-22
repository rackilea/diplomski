final NodeList<Element> metas = Document.get().getElementsByTagName("meta");

    for (int i = 0; i < metas.getLength(); i++) {
        final MetaElement m = MetaElement.as(metas.getItem(i));

        if ("gwt:property".equals(m.getName())) {
            //do something with content: m.getContent();
        }
    }