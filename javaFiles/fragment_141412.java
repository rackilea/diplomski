public void fopReport(OutputStream pdfOut, OutputStream jpgOut, Source xmlSource, Source xsltSource) throws Exception {
            // Create the FO content
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(xsltSource);
            ByteArrayOutputStream foBytesStream = new ByteArrayOutputStream();
            StreamResult foByteStreamResult = new StreamResult(foBytesStream);
            transformer.transform(xmlSource, foByteStreamResult);
            byte[] foBytes = foBytesStream.toByteArray();

            // Render twice
            FopFactory fopFactory = FopFactory.newInstance();
            FOUserAgent uaPDF = fopFactory.newFOUserAgent();
            FOUserAgent uaJpg = fopFactory.newFOUserAgent();

            Fop fopPDF = fopFactory.newFop(MimeConstants.MIME_PDF, uaPDF, pdfOut);
            Fop fopJpg = fopFactory.newFop(MimeConstants.MIME_JPEG, uaJpg, jpgOut);

            //PDF
            Source src = new StreamSource(new ByteArrayInputStream(foBytes));
            Transformer resultTransformer = factory.newTransformer();
            resultTransformer.transform(src, new SAXResult(fopPDF.getDefaultHandler()));

            //JPF
            src = new StreamSource(new ByteArrayInputStream(foBytes));
            resultTransformer = factory.newTransformer();
            resultTransformer.transform(src, new SAXResult(fopJpg.getDefaultHandler()));
        }