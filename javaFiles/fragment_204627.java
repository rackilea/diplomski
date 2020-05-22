private InputStream inputStream;

public String xmlToPdf() {
                try {
                    System.out.println("FOP ExampleXML2PDF\n");
                    System.out.println("Preparing...");

                    // Setup directories
                    File baseDir = new File("C:\\Users\\Administrator\\workspace\\path\\actions\\forms\\");
                    File outDir = new File(baseDir, "out");
                    outDir.mkdirs();

                    // Setup input and output files
                    File xmlfile = new File(baseDir, "testeFOPxml.xml");
                    File xsltfile = new File(baseDir, "xml2fo.xsl");
                    File pdffile = new File(outDir, "ResultXML2PDF.pdf");

                    System.out.println("Input: XML (" + xmlfile + ")");
                    System.out.println("Stylesheet: " + xsltfile);
                    System.out.println("Output: PDF (" + pdffile + ")");
                    System.out.println();
                    System.out.println("Transforming...");

                    // configure fopFactory as desired
                    final FopFactory fopFactory = FopFactory.newInstance();

                    FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
                    // configure foUserAgent as desired

                    ByteArrayOutputStream out = new ByteArrayOutputStream();

                    TransformerFactory tFactory = TransformerFactory.newInstance();


                    Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF,foUserAgent, out);
                    //Setup input
                    Source src = new StreamSource(xmlfile);

                    //Setup Transformer
                    Source xsltSrc = new StreamSource(xsltfile);
                    Transformer transformer = tFactory.newTransformer(xsltSrc);

                    //Make sure the XSL transformation's result is piped through to FOP
                    Result res = new SAXResult(fop.getDefaultHandler());
                    transformer.transform(src, res);

                    System.out.println("Success!");
                    ByteArrayOutputStream baos = out;
                    inputStream = new ByteArrayInputStream(baos.toByteArray());
                } catch (Exception e) {
                e.printStackTrace(System.err);
                    System.exit(-1);
                }

            return SUCCESS;
            }