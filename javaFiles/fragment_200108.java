...
    public void processSheet(
            StylesTable styles,
            ReadOnlySharedStringsTable strings,
            SheetContentsHandler sheetHandler, 
            InputStream sheetInputStream) throws IOException, SAXException {
        DataFormatter formatter = new DataFormatter() {
            @Override
            public String formatRawCellContents(double value, int formatIndex, String formatString, boolean use1904Windowing) {
                if ("m/d/yy".equals(formatString)) formatString = "m/d/yyyy";
                return super.formatRawCellContents(value, formatIndex, formatString, use1904Windowing);
            }
        };
        InputSource sheetSource = new InputSource(sheetInputStream);
        try {
            XMLReader sheetParser = SAXHelper.newXMLReader();
            ContentHandler handler = new XSSFSheetXMLHandler(
                  styles, null, strings, sheetHandler, formatter, false);
            sheetParser.setContentHandler(handler);
            sheetParser.parse(sheetSource);
         } catch(ParserConfigurationException e) {
            throw new RuntimeException("SAX parser appears to be broken - " + e.getMessage());
         }
    }
...