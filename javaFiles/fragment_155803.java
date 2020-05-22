if(DateUtil.isCellDateFormatted(cell)){
    Date myDate = cell.getDateCellValue();
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String result = formatter.format(myDate);
    System.out.println("Today : " + result);    
}