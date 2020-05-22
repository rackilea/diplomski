String inCommonMDFile = "/data/org/opensaml/saml2/metadata/InCommon-metadata.xml";

// Initialize the library
DefaultBootstrap.bootstrap(); 

// Get parser pool manager
BasicParserPool ppMgr = new BasicParserPool();
ppMgr.setNamespaceAware(true);

// Parse metadata file
InputStream in = MetadataTest.class.getResourceAsStream(inCommonMDFile);
Document inCommonMDDoc = ppMgr.parse(in);
Element metadataRoot = inCommonMDDoc.getDocumentElement();

// Get apropriate unmarshaller
UnmarshallerFactory unmarshallerFactory = Configuration.getUnmarshallerFactory();
Unmarshaller unmarshaller = unmarshallerFactory.getUnmarshaller(metadataRoot);

// Unmarshall using the document root element, an EntitiesDescriptor in this case
EntitiesDescriptor inCommonMD = (EntitiesDescriptor) unmarshaller.unmarshall(metadataRoot);