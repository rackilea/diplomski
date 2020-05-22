Constructor<HSSFCellStyle> con = HSSFCellStyle.class.getDeclaredConstructor(short.class,
    ExtendedFormatRecord.class, HSSFWorkbook.class);

con.setAccessible(true);

ExtendedFormatRecord eFR = new ExtendedFormatRecord();
short ro = 2;
eFR.setReadingOrder(ro);

short s = 0;
HSSFWorkbook generatedWb = new HSSFWorkbook();
HSSFCellStyle myStyle = con.newInstance(s, eFR, generatedWb);