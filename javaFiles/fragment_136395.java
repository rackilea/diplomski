public void addAddtlRows(Sheet sheet,Workbook workbook,DataFormatter formatter, ImportDataFormatter fmt, File file){

     //Loads and parses the regular expression into memory and creates a new StringBuilder() instance.
    final Pattern p = Pattern.compile(regex);
    StringBuilder sb = new StringBuilder();

    //Create the array which holds all the entries from a cell that contains multiple entries
    String[] sysNumber;

    //The number of the last row in the sheet.
    int lastRow = sheet.getLastRowNum();

    //Instantiates an integer that will be assigned the length of the array later
    int arrayLength;

    //Loops through the each row in the sheet 
    for(int r = 1; r < lastRow; r++){
        Row row = sheet.getRow(r);
        String cellData = formatter.formatCellValue(row.getCell(2));
        String active = formatter.formatCellValue(row.getCell(4));


        if((cellData.length() > 4) && (active.equals("Yes"))){

             /** Checks whether or not we are on the cell containing the
             * numbers and whether or not they are currently active.
             * If we are, get values for all cells in the row
             */
            String an = formatter.formatCellValue(row.getCell(0));
            String cn = formatter.formatCellValue(row.getCell(1));
            String ca = formatter.formatCellValue(row.getCell(3));
            String es = formatter.formatCellValue(row.getCell(4));
            String i10 = formatter.formatCellValue(row.getCell(5));
            String i9 = formatter.formatCellValue(row.getCell(6));
            String ia = formatter.formatCellValue(row.getCell(7));
            String rp = formatter.formatCellValue(row.getCell(8));

            /**
             * Checks the contents of the cell for more than one entry
             * If the cell contains more than one number, process
             * the data accordingly
             */

            fmt.setSysNum(cellData);
            String[] sys = String.valueOf(fmt.getSysNum()).split(",");

            /**
             * Assign the length value of the 'sysNumber' array to
             * the integer 'arrayLength'
             */
            arrayLength = sys.length;

            /**
             * Loop through each entry in the string array, creating
             * a new row on each iteration and pasting the data from
             * the old cells to the new ones
             */
            for(int n = 0; n < arrayLength; n++){
                Row nRow = sheet.createRow(sheet.getPhysicalNumberOfRows());
                nRow.createCell(0).setCellValue(an);
                nRow.createCell(1).setCellValue(cn);
                nRow.createCell(2).setCellValue(sys[n]);
                nRow.createCell(3).setCellValue(ca);
                nRow.createCell(4).setCellValue(es);
                nRow.createCell(5).setCellValue(i10);
                nRow.createCell(6).setCellValue(i9);
                nRow.createCell(7).setCellValue(ia);
                nRow.createCell(8).setCellValue(rp);

            } 
        }              
    }

    //Writes the newly added contents of the worksheet to the workbook.
    try {
    workbook.write(new FileOutputStream(file));
    } catch (FileNotFoundException ex) {
    Logger.getLogger(MapMultipleSNToDBFields.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
    Logger.getLogger(MapMultipleSNToDBFields.class.getName()).log(Level.SEVERE, null, ex);
    }
}