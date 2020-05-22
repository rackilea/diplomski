public class StringToXML {  
public static void main(String[] args) {  
    String xmlString = "<?xml version=\"1.0\" encoding=\"utf-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"></soap:Envelope>";  

     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  

    DocumentBuilder builder;  
    try  
    {  
        builder = factory.newDocumentBuilder();  

        // Use String reader  
        Document document = builder.parse( new InputSource(  
                new StringReader( xmlString ) ) );  

        TransformerFactory tranFactory = TransformerFactory.newInstance();  
        Transformer aTransformer = tranFactory.newTransformer();  
        Source src = new DOMSource( document );  
        Result dest = new StreamResult( new File( "xmlFileName.xml" ) );  
        aTransformer.transform( src, dest );  
    } catch (Exception e)  
    {  
        // TODO Auto-generated catch block  
        e.printStackTrace();  
    }  
}