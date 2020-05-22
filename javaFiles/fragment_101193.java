public class PrettyXMLConfiguration
    extends XMLConfiguration
{
    @Override
    protected Transformer createTransformer()
        throws ConfigurationException
    {
        Transformer transformer = super.createTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(
            "{http://xml.apache.org/xslt}indent-amount", "4");
        return transformer;
    }
}