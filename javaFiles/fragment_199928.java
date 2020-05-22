public static Object unmarshallWithFilter(Unmarshaller unmarshaller,
java.io.File source) throws FileNotFoundException, JAXBException 
{
    FileReader fr = null;
    try {
        fr = new FileReader(source);
        XMLReader reader = new NamespaceFilterXMLReader();
        InputSource is = new InputSource(fr);
        SAXSource ss = new SAXSource(reader, is);
        return unmarshaller.unmarshal(ss);
    } catch (SAXException e) {
        //not technically a jaxb exception, but close enough
        throw new JAXBException(e);
    } catch (ParserConfigurationException e) {
        //not technically a jaxb exception, but close enough
        throw new JAXBException(e);
    } finally {
        FileUtil.close(fr); //replace with this some safe close method you have
    }
}