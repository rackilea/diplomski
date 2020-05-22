OutputStream out = new java.io.FileOutputStream(outputFile);
out = new java.io.BufferedOutputStream(out);


try {
    //Instantiate my extension of the EPSDocumentGraphics2D instance
    MyPSDocumentGraphics2D g2d = new MyPSDocumentGraphics2D(false);
    g2d.setGraphicContext(new org.apache.xmlgraphics.java2d.GraphicContext());

    //Set up the document size
    g2d.setupDocument(out, pageWidthPT, pageHeightPT);

    g2d.setFont(new Font(font, Font.PLAIN, fontSize));
    g2d.drawString("           !", 10, 10);

    g2d.nextPage();
    // change the page orientation
    g2d.setDimension(pageHeightPT, pageWidthPT);

    g2d.drawString("Hello World!", 10, 20);
    System.out.println("Creating the document");
    g2d.finish();//Cleanup
} finally {
    IOUtils.closeQuietly(out);
}