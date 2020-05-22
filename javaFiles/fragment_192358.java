public class VieSourceExtractor implements SourceExtractor<YourObj>
{
@Override
public List<YourObj> extractData(Source src) throws IOException, TransformerException
{
XMLStreamReader reader = null;
try
{
reader = StaxUtils.getXMLStreamReader(src);
//read the xml and create your obj
return yourResult;
}
catch (Exception e)
{
throw new TransformerException(e);
}
finally
{
if (reader != null)
{
try
{
reader.close();
}
catch (XMLStreamException e)
{
logger.error("Error " + e.getMessage(), e);
}
}
}
}
}