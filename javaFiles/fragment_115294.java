public class MyExchangeConverter implements Converter {

    protected static XmlPullParser pullParser;
    protected static XmlPullParser getPullParser() {
        if (pullParser == null) {
            try {
                pullParser = XmlPullParserFactory.newInstance().newPullParser();
            } 
            catch (XmlPullParserException e) { } // Ah nuts! 
        }
        return pullParser;
    }

    @Override
    public boolean canConvert(@SuppressWarnings("rawtypes") Class type) {
        return MyDocument.class.equals(type);
    }

    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer,
            MarshallingContext context) {
        MyDocument request = (MyDocument) source;
        if (request.getMyChildDocument() != null) {
            HierarchicalStreamReader reader;
            reader = new XppReader(new StringReader(request.getMyChildDocument()), getPullParser());
            HierarchicalStreamCopier copier = new HierarchicalStreamCopier();
            copier.copy(reader, writer);
        }
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader,
            UnmarshallingContext context) {
        MyDocument response = new MyDocument();
        reader.moveDown();
        Writer out = new StringWriter(); 
        HierarchicalStreamWriter writer = new CompactWriter(out);
        HierarchicalStreamCopier copier = new HierarchicalStreamCopier();
        copier.copy(reader, writer);
        response.setMyChildDocument(out.toString());
        reader.moveUp();
        return response;
    }
}