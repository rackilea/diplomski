// Add a SectPr and header/footer policy so document can be opened and read by POI
try {
    document.getDocument().getBody().addNewSectPr();
    new XWPFHeaderFooterPolicy(document);
} catch (IOException | XmlException exception) {
    LOGGER.warn("Could not create output document header - "
            + "document might not be readable in all readers");
}