@Test
public void buildDTD2()
        throws IOException, JDOMException
{
    final PathMatchingResourcePatternResolver pmrpr = new PathMatchingResourcePatternResolver();
    final File file = pmrpr.getResource("daisy/mathmldtdtemplate.xml").getFile();
    final String uri = file.toURI().toString();
    final InputStream stream = new BufferedInputStream(new FileInputStream(file));
    final SAXBuilder saxBuilder = new SAXBuilder();

    saxBuilder.setValidation(true);
    saxBuilder.setFeature("http://apache.org/xml/features/validation/schema", true);

    saxBuilder.setExpandEntities(false);

    final InputSource source = new InputSource(new BufferedInputStream(stream));
    source.setSystemId(uri);
    final Document doc = saxBuilder.build(source);

    String xml2 = new XMLOutputter().outputString(doc);
    System.out.println(xml2);
    System.out.println("Internal Subset: " + doc.getDocType().getInternalSubset());
}