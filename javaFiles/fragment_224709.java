public class XXHeaderXMLReader
    extends StreamReaderDelegate
{

    public SBIsoHeaderXMLReader(XMLStreamReader paramXMLStreamReader)
    {
        super(paramXMLStreamReader);
    }

    @Override
    public String getAttributeNamespace(int paramInt)
    {
        return "";
    }

    @Override
    public String getNamespaceURI()
    {
        return "";
    }

}