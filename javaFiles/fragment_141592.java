protected int countImagesWithProcessor(PDDocument pdf) throws IOException {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();

    PdfImageCounter counter = new PdfImageCounter();
    for (PDPage pdPage : pdf.getPages()) {
        counter.processPage(pdPage);
    }

    stopWatch.stop();
    int imageCount = counter.getDocumentImageCount();
    log.info("Images counted: time={}s,imageCount={}", stopWatch.getTime() / 1000, imageCount);
    return imageCount;
}