if(HSSFDateUtil.isCellDateFormatted(value))
     {
     if(HSSFDateUtil.isADateFormat((int)value.getNumericCellValue(), "dd:mmm:yyyy"))
                    {
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                        String date = df.format(value.getDateCellValue());
                        data.add(date);
                    }