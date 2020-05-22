DataSource dataSource = componentInstanceService.getResource(componentResourceType);
DataHandler handler = new DataHandler(dataSource);

DataFlavor flavor = DataFlavor.selectBestTextFlavor(
    handler.getTransferDataFlavors());

if (flavor == null) {
    // This should never happen with text files.
    throw new IllegalArgumentException(
        "Data has no flavors capable of supplying text.");
}

String result;
try (Reader reader = flavor.getReaderForText(handler)) {
    StringBuilder s = new StringBuilder();
    int c;
    while ((c = reader.read()) >= 0) {
        s.append((char) c);
    }
    result = s.toString();
} catch (UnsupportedFlavorException e) {
    // Since we started with a flavor provided by the DataHandler,
    // we should never get here.
    throw new RuntimeException(e);
}