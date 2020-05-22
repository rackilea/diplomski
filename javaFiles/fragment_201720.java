//open input file
BufferedReader br = new BufferedReader(new FileReader("input.csv"));
//create sheet
Workbook wb = new XSSFWorkbook();
Sheet sheet = wb.createSheet();
//read from file
String line = br.readLine();
for (int rows=0; line != null; rows++) {
    //create one row per line
    Row row = sheet.createRow(rows);
    //split by semicolon
    String[] items = line.split(";");
    //ignore first item
    for (int i=1, col=0; i<items.length; i++) {
        //strip quotation marks
        String item = items[i].substring(1, items[i].length()-1);
        Cell cell = row.createCell(col++);
        //set item
        cell.setCellValue(item);
    }
    //read next line
    line = br.readLine();
}
//write to xlsx
FileOutputStream out = new FileOutputStream("Output.xlsx");
wb.write(out);
//close resources
br.close();
out.close();