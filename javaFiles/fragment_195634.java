if (DateUtil.isCellDateFormatted(cell)) {
    Date date = cell.getDateCellValue();

    System.out.println(date);

    String dateFmt = "";

    if (cell.getCellStyle().getDataFormat() == 14) { //default short date without explicit formatting
     dateFmt = "dd/mm/yyyy"; //default date format for this
    } else { //other data formats with explicit formatting
     dateFmt = cell.getCellStyle().getDataFormatString();
    }

    System.out.println("dateFmt " + dateFmt);

    String value = new CellDateFormatter(dateFmt).format(date);

    System.out.println("Date " + value);

   }