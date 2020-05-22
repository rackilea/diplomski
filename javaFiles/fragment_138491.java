InputStream caInput = new BufferedInputStream(getAssets().open(
                            "ie_data.xlsx"));

            XSSFWorkbook workbook = new XSSFWorkbook(caInput);
            XSSFSheet feuille = workbook.getSheetAt(0);

            Cell cell = feuille.getRow(0).getCell(0);

            String value = cell.getStringCellValue() + "";

            System.out.print("hello = " + value);