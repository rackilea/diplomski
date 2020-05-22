public ExcelReaderAndWriter(String inputFileName,String outputFileName) throws IOException, InvalidFormatException {

// Creating a Workbook from an Excel file (.xls or .xlsx)


try (Workbook workbook = WorkbookFactory.create(new File(inputFileName))) {



    // Getting the Sheet at index zero
    Sheet sheet = workbook.getSheet("XSL_RULES");

    // Create a DataFormatter to format and get each cell's value as String
    DataFormatter dataFormatter = new DataFormatter();

    //obtain a rowIterator and columnIterator and iterate over them
    System.out.println("\n\nIterating over Rows and Columns using Iterator\n");

    Iterator <Row> rowIterator = sheet.rowIterator();
    while (rowIterator.hasNext()) {
        Row row = rowIterator.next();

        // Now let's iterate over the columns of the current row
        Iterator <Cell> cellIterator = row.cellIterator();

        if (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            String cellValue = dataFormatter.formatCellValue(cell);

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = null;
            try {
                docBuilder = docFactory.newDocumentBuilder();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("ROOT");
            doc.appendChild(rootElement);
            // TOMORROW CREATE A LOOP TO GET ALL THE FILES and NODES.

            for (int k = 1; k <= sheet.getLastRowNum(); k++) {
                Element xslt_rule = doc.createElement("RULES");

                    xslt_rule.setAttribute("ATTR1"sheet.getRow (k).getCell (0).getStringCellValue ());
                    xslt_rule.setAttribute("ATTR2", sheet.getRow (k).getCell (1).getStringCellValue ());
                    xslt_rule.setAttribute("ATTR3", sheet.getRow (k).getCell (2).getStringCellValue ());

                }

                xslt_rule.appendChild(doc.createTextNode(sheet.getRow (k).getCell (28).getStringCellValue ());
                rootElement.appendChild(xslt_rule);


            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = null;

            try

            {
                transformer = transformerFactory.newTransformer();
            } catch (TransformerConfigurationException e)

            {
                e.printStackTrace();
            }

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(outputFileName));


            try {
                transformer.transform(source, result);
            } catch (TransformerException e) {
                e.printStackTrace();
            }


        }
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}