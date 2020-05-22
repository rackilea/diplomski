public static void main(String argv[])
{
    try
    {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        MyDefaultHandler handler = new MyDefaultHandler();
        saxParser.parse("c:\\input.xml", handler);
        System.out.println(handler.getXList() + ", " + handler.getYList());
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
}

static class MyDefaultHandler extends DefaultHandler
{
    private List<Integer> xList = new ArrayList<Integer>();
    private List<Integer> yList = new ArrayList<Integer>();
    boolean xele = false;
    boolean yele = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {

        if (qName.equalsIgnoreCase("X"))
        {
            xele = true;
        }

        if (qName.equalsIgnoreCase("Y"))
        {
            yele = true;
        }

    }

    public void characters(char ch[], int start, int length) throws SAXException
    {

        if (xele)
        {
            System.out.println("X value : " + new String(ch, start, length));
            xele = false;
            xList.add(Integer.parseInt(new String(ch, start, length)));
        }

        if (yele)
        {
            System.out.println("Y value : " + new String(ch, start, length));
            yele = false;
            yList.add(Integer.parseInt(new String(ch, start, length)));
        }
    }

    public List<Integer> getXList()
    {
        return xList;
    }

    public List<Integer> getYList()
    {
        return yList;
    }

};