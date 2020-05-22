public byte[] getReport(String templateFile, String outFileType) {
    byte[] dataBytes = null;
    try {
        //Process RTF template to convert to XSL-FO format
        RTFProcessor rtfp = new RTFProcessor(templateFile);
        ByteArrayOutputStream xslOutStream = new ByteArrayOutputStream();
        rtfp.setOutput(xslOutStream);
        rtfp.process();

        ByteArrayInputStream xslInStream = new ByteArrayInputStream(xslOutStream.toByteArray());

        FOProcessor processor = new FOProcessor();
        ByteArrayInputStream dataStream = new ByteArrayInputStream(getXMLData());
        processor.setData(dataStream);
        processor.setTemplate(xslInStream);

        ByteArrayOutputStream pdfOutStream = new ByteArrayOutputStream();
        processor.setOutput(pdfOutStream);
        byte outFileTypeByte = FOProcessor.FORMAT_PDF;
        if ("HTML".equalsIgnoreCase(outFileType)) {
            outFileTypeByte = FOProcessor.FORMAT_HTML;
        } else if ("RTF".equalsIgnoreCase(outFileType)) {
            outFileTypeByte = FOProcessor.FORMAT_RTF;
        }
        processor.setOutputFormat(outFileTypeByte);
        processor.generate();

        dataBytes = pdfOutStream.toByteArray();

    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("IOException when generating pdf " + e);

    } catch (XDOException e) {
        e.printStackTrace();
        System.out.println("XDOException when generating pdf " + e);

    }
    return dataBytes;
}