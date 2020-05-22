public XExcelFileReader(final String excelPath) throws Exception {
    this.opcPkg = OPCPackage.open(excelPath, PackageAccess.READ);
    XSSFReader xssfReader = new XSSFReader(this.opcPkg);
    this.stringsTable = xssfReader.getSharedStringsTable();

    XMLInputFactory factory = XMLInputFactory.newInstance();
    InputStream inputStream = xssfReader.getSheetsData().next();
    this.xmlReader = factory.createXMLStreamReader(inputStream);

    while (this.xmlReader.hasNext()) {
      this.xmlReader.next();
      if (this.xmlReader.isStartElement()) {
        if (this.xmlReader.getLocalName().equals("sheetData")) {
          break;
        }
      }
    }
  }