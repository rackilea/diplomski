public void initCsvFile() {
    try {
        writer = new CSVWriter(new FileWriter(filePath), ';', '"');
    } catch (IOException e) {
        logger.error("CsvBuilder : error when creating {}", filePath, e);
        throw new CsvException("Error when creating the file : " + filePath, e);
    }
}