StylesTable styles = reader.getStylesTable();
ReadOnlySharedStringsTable sharedStrings = new ReadOnlySharedStringsTable(pkg);
ContentHandler handler = new XSSFSheetXMLHandler(styles, sharedStrings, mySheetContentsHandler, true);

XMLReader parser = XMLReaderFactory.createXMLReader();
parser.setContentHandler(handler);
parser.parse(new InputSource(reader.getSheetsData().next()));