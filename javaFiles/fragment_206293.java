public String execute(){

    setContentDisposition("attachment; filename=\"" + ename + ".xls\"");

    try{
        HSSFWorkbook hwb=new HSSFWorkbook();
        HSSFSheet sheet =  hwb.createSheet("new sheet");

        //////You can repeat this part using for or while to create multiple rows//////
            HSSFRow row = sheet.createRow(rowNum);
            row.createCell(0).setValue("col0");
            row.createCell(1).setValue("col1");
            row.createCell(2).setValue("col2");
            row.createCell(3).setValue("col3");
            .
            .
            .
        ///////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////////////////////////
        //////Now you are ready with the HSSFworkbook object to be sent to client//////
        ///////////////////////////////////////////////////////////////////////////////

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        hwb.write(baos);
        excelStream = new ByteArrayInputStream(baos.toByteArray());

        ///////////////////////////////////////////////////////////////////////////////
        ////Here HSSFWorkbook object is sent directly to client w/o saving on server///
        ///////////////////////////////////////////////////////////////////////////////
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
    return SUCCESS;
}