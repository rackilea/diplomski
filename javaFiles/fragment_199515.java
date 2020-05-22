public class XMPExample {
public static String transformXML(Node xml) throws Exception {
    StringWriter writer = new StringWriter();

    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.transform(new DOMSource(xml), new StreamResult(writer));

    return writer.toString();
}

public static Document transformXML(String xml) throws Exception {
    StringReader reader = new StringReader(xml);
    Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    Transformer transformer = TransformerFactory.newInstance().newTransformer();

    transformer.transform(new StreamSource(reader), new DOMResult(doc));
    return doc;
}

public static String getXMP(Element metadata_dom) throws Exception {
            // (Element) type because getElementsByTagName() method is required

    // There are many more robust ways of selecting nodes
    // (e.g. javax.xml.xpath), but this is for a simple example
    // that only uses the native DOM methods

    // This is very brittle because we're making assumptions about
    // the metadata_dom structure. There are two sources of brittleness:

    // 1. The metadata format from `metadata.getMetadataFormatNames()`.
    //    You should probably settle on a standard one you know will
    //    exist, like 'javax_imageio_1.0'
    // 2. How the image stores the metadata. Usually XMP data will
    //    be in a text field with keyword 'XML:com.adobe.xmp', but
    //    I don't know that this is *always* the case.

    // the code below assumes "javax_imageio_png_1.0" format
    NodeList iTXtEntries = metadata_dom.getElementsByTagName("iTXtEntry");
    Element iTXtEntry = null;
    Element entry = null;
    for (int i = 0; i < iTXtEntries.getLength(); i++) {
        entry = (Element) iTXtEntries.item(i);
        if (entry.getAttribute("keyword").equals("XML:com.adobe.xmp")) {
            iTXtEntry = entry;
            break;
        }
    }
    if (iTXtEntry == null) {
        return null;
    }

    String xmp_xml_doc = iTXtEntry.getAttribute("text");

    return xmp_xml_doc;

}
}