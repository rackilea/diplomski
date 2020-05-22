LinkedList<String[]> text_lines = new LinkedList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("C:\\arquivo.txt"))) {
        String sCurrentLine;
        while ((sCurrentLine = br.readLine()) != null) {
            text_lines.add(sCurrentLine.split("\\t"));                 
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    String fileName = "C:/Testing.xls";
    Workbook workbook = new HSSFWorkbook();
    Sheet sheet = workbook.createSheet("Teste");
    int row_num = 0;
    for(String[] line : text_lines){
        Row row = sheet.createRow(row_num++);
        int cell_num = 0;
        for(String value : line){
            Cell cell = row.createCell(cell_num++);
            cell.setCellValue(value);
        }
    }

    FileOutputStream fileOut = new FileOutputStream(fileName);
    workbook.write(fileOut);
    fileOut.close();