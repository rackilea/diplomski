public void parseExcel(File file) throws IOException {

            OPCPackage container;
            try {
                container = OPCPackage.open(file.getAbsolutePath());
                ReadOnlySharedStringsTable strings = new ReadOnlySharedStringsTable(container);
                XSSFReader xssfReader = new XSSFReader(container);
                StylesTable styles = xssfReader.getStylesTable();
                XSSFReader.SheetIterator iter = (XSSFReader.SheetIterator) xssfReader.getSheetsData();
                while (iter.hasNext()) {
                    InputStream stream = iter.next();

                    processSheet(styles, strings, stream);
                    stream.close();
                }
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (OpenXML4JException e) {
                e.printStackTrace();
            }

    }

    protected void processSheet(StylesTable styles, ReadOnlySharedStringsTable strings, InputStream sheetInputStream) throws IOException, SAXException {

            InputSource sheetSource = new InputSource(sheetInputStream);
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            try {
                SAXParser saxParser = saxFactory.newSAXParser();
                XMLReader sheetParser = saxParser.getXMLReader();
                ContentHandler handler = new XSSFSheetXMLHandler(styles, strings, new SheetContentsHandler() {

                @Override
                    public void startRow(int rowNum) {
                    }
                    @Override
                    public void endRow() {
                    }
                    @Override
                    public void cell(String cellReference, String formattedValue) {
                    }
                    @Override
                    public void headerFooter(String text, boolean isHeader, String tagName) {

                    }

                }, 
                false//means result instead of formula
                );
                sheetParser.setContentHandler(handler);
                sheetParser.parse(sheetSource);
            } catch (ParserConfigurationException e) {
                throw new RuntimeException("SAX parser appears to be broken - " + e.getMessage());


}