new org.xml.sax.EntityResolver() 
{
    @Override
    public InputSource resolveEntity(String publicId, String systemId)
    {
        if (systemId != null && systemId.equals("http://something.com/xml.dtd"))
            return new InputSource(getClass().getResourceAsStream("../xml/local.dtd"));;
    }
};