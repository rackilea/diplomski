DataFormatter formatter = new DataFormatter();

 .....

 if(HSSFDateUtil.isCellDateFormatted(value)) {
     String date = formatter.formatCell(value);
 }