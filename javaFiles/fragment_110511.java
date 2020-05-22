private static void transform(org.w3c.dom.Document doc, java.io.InputStream inputXsl, java.io.OutputStream out)
    throws java.io.IOException,
    javax.xml.transform.TransformerConfigurationException,
    javax.xml.transform.TransformerException
{
    javax.xml.transform.Templates templates=javax.xml.transform.TransformerFactory.newInstance().newTemplates(new javax.xml.transform.stream.StreamSource(inputXsl));
    javax.xml.transform.Transformer transformer=templates.newTransformer();
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
    javax.xml.transform.Result result=new javax.xml.transform.stream.StreamResult(out);
    javax.xml.transform.Source source=new javax.xml.transform.dom.DOMSource(doc);
    if (doc.getInputEncoding() != null)
    {
        transformer.setOutputProperty("encoding", doc.getInputEncoding());
    }
    transformer.transform(source, result);
}