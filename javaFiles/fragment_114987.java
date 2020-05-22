public String generateGeneralXlsOther() throws Exception {
    try {

        String titles="eventIdPdf,eventNamePdf,companyNamePdf,eventVenuePdf,eventTimePdf,totalAmountPdf,receivedAmountPdf,receivedAmountPdf,chequeDdPdf,paymentDatePdf,eventTdsPdf,balanceAmountPdf";

        String[]arrTiltes=titles.split(",");        



        FileOutputStream fileOut = new FileOutputStream("poi-testOtehr.xls");
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet("POI Worksheet");



        HSSFRow rowTitle = worksheet.createRow(0);

        // set  titles



        for(int i=0;i<arrTiltes.length;i++){
            HSSFCell cellTitle=rowTitle.createCell(i);
            cellTitle.setCellValue(arrTiltes[i]);


        }


         int size=((List<String>) sessionMapGeneral.get(arrTiltes[0])).size();
        for(int row=0;row<size;row++){


            HSSFRow rowValue = worksheet.createRow(row+1);
            int cell=0;
          for(int i=0;i<arrTiltes.length;i++){

              List<String> theList=(List<String>) sessionMapGeneral.get(arrTiltes[i]);
              HSSFCell cell0 = rowValue.createCell(cell);
                cell0.setCellValue(theList.get(row));
                cell++;

          }
        }


        workbook.write(fileOut);
        fileOut.flush();
        fileOut.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
    return "success";
}