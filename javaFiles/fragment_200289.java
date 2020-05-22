XMLInputFactory xif = XMLInputFactory.newFactory();
        XMLStreamReader xsr = xif.createXMLStreamReader(new FileReader("input.xml"));
        xsr.nextTag(); // Advance to Envelope tag

        xsr.nextTag(); // Advance to Body tag
        xsr.nextTag();
        xsr.nextTag();

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        StringWriter stringWriter = new StringWriter();
        transformer.transform(new StAXSource(xsr), new StreamResult(stringWriter));
        StringReader sr = new StringReader(stringWriter.toString());
        JAXBContext jaxbContext = JAXBContext.newInstance(LoginResult.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        LoginResult loginResult = (LoginResult) unmarshaller.unmarshal(sr);