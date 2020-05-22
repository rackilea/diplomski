PDDocument document = null; 
document = PDDocument.load(inFile); 
List pages = document.getDocumentCatalog().getAllPages();
Iterator iter = pages.iterator(); 
while (iter.hasNext()) {
            PDPage page = (PDPage) iter.next();
            PDResources resources = page.getResources();
            Map pageImages = resources.getImages();
            if (pageImages != null) { 
                Iterator imageIter = pageImages.keySet().iterator();
                while (imageIter.hasNext()) {
                    String key = (String) imageIter.next();
                    PDXObjectImage image = (PDXObjectImage) pageImages.get(key);
                    image.write2OutputStream(/* some output stream */);
                }
            }
}