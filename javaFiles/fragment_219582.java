File xmlfile = new File(xmlFile);
File xsltfile = new File(xslFile);
File pdffile = new File(outDir, outputPDF);
//make your fop factory
final FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());


FOUserAgent foUserAgent = fopFactory.newFOUserAgent();


// Setup output
OutputStream out = new java.io.FileOutputStream(pdffile);
out = new java.io.BufferedOutputStream(out);

try {
            // Construct fop with desired output format
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            // Setup XSLT
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltfile));


            transformer.setParameter("versionParam", "2.0");

            // Setup input for transformations to take effect upon
            Source src = new StreamSource(xmlfile);

            // Generated FO file needs to be passed along to FOP
            Result res = new SAXResult(fop.getDefaultHandler());

            // Start XSLT transformation and FOP processing
            transformer.transform(src, res);
   } finally {
            out.close();
   }