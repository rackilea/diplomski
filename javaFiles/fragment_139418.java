protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    try {

        response.setContentType("application/pdf"); 

        // Setup directories
        File xmlfile = new File(getServletContext().getRealPath("/AvtoSolaZ.xml"));
        File xsltfile = new File(getServletContext().getRealPath("/AvtoSolaZaposleniXSL.xsl")); 
        File outDir = new File("WebContent");
        outDir.mkdirs();

        // configure fopFactory as desired
        FopFactory fopFactory = FopFactory.newInstance();

        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        // configure foUserAgent as desired

        // Setup output
        OutputStream out = response.getOutputStream();

        try {
            // Construct fop with desired output format
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            // Setup XSLT
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory
                    .newTransformer(new StreamSource(xsltfile));

            // Set the value of a <param> in the stylesheet
            transformer.setParameter("versionParam", "2.0");

            // Setup input for XSLT transformation
            Source src = new StreamSource(xmlfile);

            // Resulting SAX events (the generated FO) must be piped through
            // to FOP
            Result res = new SAXResult(fop.getDefaultHandler());

            // Start XSLT transformation and FOP processing
            transformer.transform(src, res);

        } finally {
            out.close();
        }

    } catch (Exception e) {
        e.printStackTrace(System.err);
        System.exit(-1);
    }
}