public class TestPercent {
  public static void main(String[] args) throws Exception {
    System.out.println("Generating...");

    for (Workbook wb : new Workbook[] {new HSSFWorkbook(), new XSSFWorkbook()}) {
        Sheet sheet = wb.createSheet("Data Sheet");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(3);

        DataFormat df = wb.createDataFormat();
        CellStyle cs = wb.createCellStyle();
        cs.setDataFormat(df.getFormat("%"));
        cell.setCellValue(0.37);
        cell.setCellStyle(cs);

        String output = "/tmp/text.xls";
        if (wb instanceof XSSFWorkbook) { output += "x"; }
        FileOutputStream out = new FileOutputStream(output);
        wb.write(out);
        out.close();
    }

    System.out.println("Done");
  }
}