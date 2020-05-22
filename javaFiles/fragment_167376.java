private int getPageRotation(String documentPath, int page) throws IOException
{
    try (PDDocument document = PDDocument.load(documentPath))
    {
        List<?> pages = document.getDocumentCatalog().getAllPages();
        PDPage pageObject =(PDPage) pages.get(page);
        return pageObject.getRotation();
    }
}