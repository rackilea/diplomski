InputStream inp = new FileInputStream("workbook.xls");
HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(inp));
ExcelExtractor extractor = new ExcelExtractor(wb);

extractor.setFormulasNotResults(true);
extractor.setIncludeSheetNames(false);
String text = extractor.getText();