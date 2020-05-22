try (   PDDocument document = PDDocument.load(FILE_PATH) ) {
    for (PDPage page : document.getDocumentCatalog().getPages()) {
        PdfBoxFinder boxFinder = new PdfBoxFinder(page);
        boxFinder.processPage(page);

        PDFTextStripperByArea stripperByArea = new PDFTextStripperByArea();
        for (Map.Entry<String, Rectangle2D> entry : boxFinder.getRegions().entrySet()) {
            stripperByArea.addRegion(entry.getKey(), entry.getValue());
        }

        stripperByArea.extractRegions(page);
        List<String> names = stripperByArea.getRegions();
        names.sort(null);
        for (String name : names) {
            System.out.printf("[%s] %s\n", name, stripperByArea.getTextForRegion(name));
        }
    }
}