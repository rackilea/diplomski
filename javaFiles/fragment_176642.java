public static void MapExample() throws SaxonApiException {
    Processor processor = new Processor(false);

    XsltExecutable executable = processor.newXsltCompiler().compile(new StreamSource("sheet.xsl"));

    Xslt30Transformer transformer = executable.load30();

    Map<String,String> mapData = new HashMap<String,String>();
    mapData.put("1", "188 E 6th Street");

    HashMap<QName, XdmValue> parameters = new HashMap<>();

    parameters.put(new QName("mapData"), XdmMap.makeMap(mapData));

    transformer.setStylesheetParameters(parameters);

    transformer.applyTemplates(new StreamSource("input1.xml"), transformer.newSerializer(System.out));

    System.out.println();        
}