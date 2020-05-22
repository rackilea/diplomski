class BaseTestCategoryMethods {
    public static String schemaVersion(String self, String version) {
        def root = new XmlParser().parseText(self)
        root.attributes().put("version", version)
        StringWriter sw = new StringWriter()
        def printer = new XmlNodePrinter(new PrintWriter(sw), "")
        printer.setPreserveWhitespace(true)
        printer.print(root);
        return sw.toString().readLines().join()
    }
 }