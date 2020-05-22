public static void main(String[] args) {
    WritableWorkbook exceptionWB = null;
    try{
        exceptionWB = Workbook.createWorkbook(new File("filename.xls");
        WritableSheet excepSheet=exceptionWB.createSheet("Exceptions",0);
        int exceptionRow=1;

        for(int i=0; i<numberOfRecords;i++) {
            processRow(argument1, argument2, excepSheet, exceptionRow);
        }
        catch (Exception e) {
            //You should now have access to the exceptionWB
            Label exception1=new Label(0, exceptionRow, e.getMessage());
            exceptionWB.write();
        }
}