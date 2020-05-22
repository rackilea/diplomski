private static void lockAll(Sheet s, XSSFWorkbook workbookx){
    String password= "abcd";
    byte[] pwdBytes = null;
    try {
        pwdBytes  = Hex.decodeHex(password.toCharArray());
    } catch (DecoderException e) {
        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }
    XSSFSheet sheet = ((XSSFSheet)s);
    removePivot(s,workbookx);
    sheet.lockDeleteColumns();
    sheet.lockDeleteRows();
    sheet.lockFormatCells();
    sheet.lockFormatColumns();
    sheet.lockFormatRows();
    sheet.lockInsertColumns();
    sheet.lockInsertRows();
    sheet.getCTWorksheet().getSheetProtection().setPassword(pwdBytes);
    for(byte pwdChar :pwdBytes){
        System.out.println(">>> Sheet protected with '" + pwdChar + "'");
    }
    sheet.enableLocking();

    workbookx.lockStructure();

}