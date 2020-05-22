public void exportToPDF(JFreeChart chart, String filePath){
    PDDocument doc = null;
    PDPage page = null;
    PDXObjectImage ximage = null;
    try {
        doc = new PDDocument();
        page = new PDPage();
        doc.addPage(page);
        PDPageContentStream content = new PDPageContentStream(doc, page);

        //create a new outStream
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ChartUtilities.writeChartAsJPEG(out, chart, 300, 300);//write to outstream
        //create a new inputstream
        InputStream in = new ByteArrayInputStream(out.toByteArray());
        ximage = new PDJpeg(doc, in);
        content.drawImage(ximage, 5, 300);
        content.close();
    }
    catch (IOException ie){
        //handle exception
    }
    //save and close
    doc.save(filePath);
    doc.close();
}