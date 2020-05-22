public static void main(String[] args) throws IOException {

        System.out.println("Enter the id:");
        Scanner s = new Scanner(System.in);
        String id = s.next();

        FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
        Workbook wb = new XSSFWorkbook(excelFile);
        DataFormatter formatter = new DataFormatter();
        for (int i = 0; i < wb.getNumberOfSheets(); i++) {
            System.out.println();
            System.out.println();
            System.out.println("Data for Sheet" + " " + (i + 1));
            System.out.println("-----------------------------------");
            System.out.println();
            System.out.println();
            Sheet datatypeSheet = wb.getSheetAt(i);
            Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                if(id.equals(formatter.formatCellValue(currentRow.getCell(0)))) {
                    currentRow.cellIterator().forEachRemaining(c -> System.out.print(formatter.formatCellValue(c) + " "));
                }
            }
        }
        wb.close();
        s.close();
}