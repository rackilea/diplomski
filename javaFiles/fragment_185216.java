private List<Object> getWmlObjects(WordprocessingMLPackage wordMLPackage, String xhtmlDocumentAsString) {

    try {
        DocxRenderer renderer = new DocxRenderer();

        // override the user agent
        FieldAccessUtils.setField(renderer, "userAgent", new ProfileImageDocx4jUserAgent());

        // override the replaced element factory
        Docx4jDocxOutputDevice outputDevice = (Docx4jDocxOutputDevice) FieldAccessUtils.getField(renderer,
                "_outputDevice");
        renderer.getSharedContext().setReplacedElementFactory(
                new ProfileImageDocx4jReplacedElementFactory(outputDevice));

        // build the XHTMLImporter instance as it does in XHTMLImporter.convert but with our new renderer

        XHTMLImporter importer; // = new XHTMLImporter(wordMLPackage);
        Constructor<XHTMLImporter> constructor = XHTMLImporter.class
                .getDeclaredConstructor(WordprocessingMLPackage.class);
        constructor.setAccessible(true);
        importer = constructor.newInstance(wordMLPackage);
        constructor.setAccessible(false);

        FieldAccessUtils.setField(importer, "renderer", renderer);

        InputSource is = new InputSource(new BufferedReader(new StringReader(xhtmlDocumentAsString)));
        Document dom = XMLResource.load(is).getDocument();

        renderer.setDocument(dom, null);
        renderer.layout();

        // use reflection to do: importer.traverse(renderer.getRootBox(), FieldAccessUtils.getField(importer, "imports"), null);
        Method traverseMethod = importer.getClass().getDeclaredMethod("traverse", Box.class, List.class,
                TableProperties.class);
        traverseMethod.setAccessible(true);
        traverseMethod.invoke(importer, renderer.getRootBox(), FieldAccessUtils.getField(importer, "imports"), null);
        traverseMethod.setAccessible(false);

        return (List<Object>) FieldAccessUtils.getField(importer, "imports");

    } catch (SecurityException e) {
        getLogger().error(ExceptionUtils.getStackTrace(e));
    } catch (NoSuchMethodException e) {
        getLogger().error(ExceptionUtils.getStackTrace(e));
    } catch (IllegalArgumentException e) {
        getLogger().error(ExceptionUtils.getStackTrace(e));
    } catch (IllegalAccessException e) {
        getLogger().error(ExceptionUtils.getStackTrace(e));
    } catch (InvocationTargetException e) {
        getLogger().error(ExceptionUtils.getStackTrace(e));
    } catch (InstantiationException e) {
        getLogger().error(ExceptionUtils.getStackTrace(e));
    }

    try {
        // plan B
        return XHTMLImporter.convert(xhtmlDocumentAsString, null, wordMLPackage);
    } catch (Docx4JException e) {
        getLogger().error(ExceptionUtils.getStackTrace(e));
    }

    return null;
}