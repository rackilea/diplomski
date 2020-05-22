private static final String WATERMARK_RESOURCE_PATH = "/watermark/hcro_copy.png";

public void watermark(File pdfFile, OutputStream output) throws IOException {
    try (final InputStream sourceStream = new FileInputStream(pdfFile);
         final PDDocument document = PDDocument.load(sourceStream)
    ) {
        for (int pageNumber = 0; pageNumber < document.getNumberOfPages(); pageNumber++) {
            PDPage currPage  = document.getPage(pageNumber);
            writeWatermarkWithTransparentImageOnPage(document, currPage);
        }
        document.save(output);
    }
}

private void writeWatermarkWithTransparentImageOnPage(PDDocument document, PDPage page)
        throws IOException {
    try (PDPageContentStream contentStream = new PDPageContentStream(
            document, page, PDPageContentStream.AppendMode.APPEND, true, true);
         InputStream watermarkFileStream = getWatermarkFileStream()
    ) {
        // Load watermark image
        BufferedImage image = ImageIO.read(watermarkFileStream);
        PDImageXObject pdxImage = LosslessFactory.createFromImage(document, image);

        // Set the opacity
        PDExtendedGraphicsState extendedGraphicsState = new PDExtendedGraphicsState();
        extendedGraphicsState.setNonStrokingAlphaConstant(0.35f);
        contentStream.setGraphicsStateParameters(extendedGraphicsState);

        // Center watermark image on page
        PDRectangle rect = page.getBBox();
        int imageX = Math.floorDiv((Math.round(rect.getWidth()) - pdxImage.getWidth()), 2);
        int imageY = Math.floorDiv((Math.round(rect.getHeight()) - pdxImage.getHeight()), 2);

        contentStream.drawImage(pdxImage, imageX, imageY);
    }
}

private InputStream getWatermarkFileStream() {
    try {
        Resource resource = new ClassPathResource(WATERMARK_RESOURCE_PATH);
        return resource.getInputStream();
    }
    catch (IOException e) {
        throw new RuntimeException(e);
    }
}