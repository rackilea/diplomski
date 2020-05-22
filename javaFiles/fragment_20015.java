final InputStream zipStream = zip.getInputStream(entry);
InputSupplier<InputStream> supplier = new InputSupplier<InputStream>() {
    InputStream getInput() {
        return zipStream;
    }
};
Files.copy(supplier, unzippedEntryFile);