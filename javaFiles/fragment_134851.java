String bakecaPath = configurationManager.getProviderParam(CommonConstants.THIRD_PARTY_PROVIDER_NAME, CommonConstants.BAKECA_FEED_XML_PATH);

File bakecaOutputFile = new File(bakecaPath);
bakecaStream = new ZipOutputStream(new FileOutputStream(bakecaOutputFile));

innerFileName = bakecaOutputFile.getName().replace(".zip", ".xml");
ze = new ZipEntry(innerFileName);

bakecaStream.putNextEntry(ze);

bakecaWriter = xmlOutputFactory.createXMLStreamWriter(bakecaStream, UTF_8);
Marshaller bakecaMarshaller = constructMarshaller(BakecaAd.class);
bakecaWriter.writeStartDocument(UTF_8,"1.0");
bakecaWriter.writeStartElement(getRootElementName(Bakeca.class));
bakecaWriter.writeEndElement();
bakecaWriter.writeEndDocument();

bakecaStream.closeEntry();
closeWriter(bakecaWriter);

// create the next file
ZipEntry anotherFile = new ZipEntry("filename");

bakecaStream.putNextEntry(anotherFile);

// write to the second file here; you can write to bakecaStream again

bakecaStream.closeEntry();