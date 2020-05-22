private static boolean isXMLwellformed(File file) throws IOException
   {
    boolean isWellformed = true;
    BufferedReader br = new BufferedReader(new FileReader(file));
    TransformerFactory factory = TransformerFactory.newInstance();
    StreamSource source = new StreamSource(br);
    try 
    {
        Transformer trans = factory.newTransformer();
        SAXResult sink = new SAXResult(new DefaultHandler());
        trans.transform(source, sink);
    } 
    catch (TransformerException err) 
    {
        System.err.println("Validation failed: " + err.getMessage());
        br.close();
        isWellformed = false;
    }
    return isWellformed;
    }