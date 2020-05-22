System.setProperty("javax.xml.transform.TransformerFactory", "net.sf.saxon.TransformerFactoryImpl");  // use saxon for xslt 2.0 support
File styleSheet = new File("filePath");

// Get a TransformerFactory
System.setProperty("javax.xml.transform.TransformerFactory",
                   "com.saxonica.config.ProfessionalTransformerFactory");
TransformerFactory tfactory = TransformerFactory.newInstance();
ProfessionalConfiguration config = (ProfessionalConfiguration)((TransformerFactoryImpl)tfactory).getConfiguration();

// Get a SAXBuilder 
SAXBuilder builder = new SAXBuilder(); 

//Build JDOM Document
Document toTransform = builder.build(inputFileHandle); 

//Give it a Saxon wrapper
DocumentWrapper docw = new DocumentWrapper(toTransform,  inputHandle.getAbsolutePath(), config);

// Compile the stylesheet
Templates templates = tfactory.newTemplates(new StreamSource(styleSheet));
Transformer transformer = templates.newTransformer();

// Now do a transformation
ByteArrayOutputStream outStream = new ByteArrayOutputStream(1024);                  
transformer.transform(docw, new StreamResult(outStream));

ByteArrayInputStream inStream = new ByteArrayInputStream(outStream.toByteArray());
Document transformed = builder.build(inStream);