public static PDOptionalContentGroup appendImageAsLayer(PDDocument document, PDPage targetPage, BufferedImage image, String layerName) throws IOException {
    PDDocumentCatalog catalog = document.getDocumentCatalog();
    PDOptionalContentProperties ocprops = catalog.getOCProperties();
    if (ocprops == null) {
        ocprops = new PDOptionalContentProperties();
        catalog.setOCProperties(ocprops);
    }
    if (ocprops.hasGroup(layerName)) {
        throw new IllegalArgumentException("Optional group (layer) already exists: " + layerName);
    }

    PDOptionalContentGroup layer = new PDOptionalContentGroup(layerName);
    ocprops.addGroup(layer);

    PDResources resources = targetPage.findResources();
    if(resources == null ) {
        resources = new PDResources(new COSDictionary());
        targetPage.setResources(resources);
    }
    PDPropertyList props = resources.getProperties();
    if (props == null) {
        props = new PDPropertyList();
        resources.setProperties(props);
    }

    // Find first free resource name with the pattern "MC<index>"
    int index = 0;
    PDOptionalContentGroup ocg;
    COSName resourceName;
    do {
        resourceName = COSName.getPDFName("MC" + index);
        ocg = props.getOptionalContentGroup(resourceName);
        index++;
    } while (ocg != null);
    // Put mapping for our new layer/OCG
    props.putMapping(resourceName, layer);
    PDJpeg img = new PDJpeg(document, image);

    PDPageContentStream contentStream = new PDPageContentStream(document, targetPage, true, false);
    contentStream.beginMarkedContentSequence(COSName.OC, resourceName);
    contentStream.drawImage(img, 0, 0);
    contentStream.endMarkedContentSequence();
    contentStream.close();

    return layer;
}