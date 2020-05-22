public Suite getTestSuiteFromJar(String jarFilePath, String filename) {
    File jarFile  = new File(jarFilePath);
    Suite suite = null;
    try {
        if (jarFile.isFile()) {
            final JarFile jar = new JarFile(jarFile);

            InputStream in = jar.getInputStream(new ZipEntry(filename));
            suite = XmlUtil.parseSuite(in);
            jar.close();
        }

    } catch (IOException | JAXBException | SAXException | ParserConfigurationException e) {
        e.printStackTrace();
    }
    return suite;
}

public static Suite parseSuite(InputStream is) throws JAXBException, SAXException, ParserConfigurationException {
    JAXBContext jaxbContext = JAXBContext.newInstance(Suite.class);
    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    return (Suite) jaxbUnmarshaller.unmarshal(is);
}