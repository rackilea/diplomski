try {
                InputStream caInput = new BufferedInputStream(getAssets().open(
                        "ie_data.xls"));
                HSSFWorkbook workbook = new HSSFWorkbook(caInput);
                HSSFSheet feuille = workbook.getSheetAt(0);

                Cell cell = feuille.getRow(1).getCell(1);

                String value = cell.getNumericCellValue()+"";
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_LONG)
                        .show();
            } catch (IOException e1) {
                // TODO Auto-generated catch block


e1.printStackTrace();
        }