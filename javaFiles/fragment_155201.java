JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
MySchemaOutputResolver sor = new MySchemaOutputResolver();
jaxbContext.generateSchema(sor);
String schema = sor.getSchema();

public class MySchemaOutputResolver extends SchemaOutputResolver {
    private StringWriter stringWriter = new StringWriter();    

    public Result createOutput(String namespaceURI, String suggestedFileName) throws IOException  {
        StreamResult result = new StreamResult(stringWriter);
        result.setSystemId(suggestedFileName);
        return result;
    }

    public String getSchema() {
        return stringWriter.toString();
    }

}