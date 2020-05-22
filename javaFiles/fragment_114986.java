public  String generateGeneralXls() throws Exception {
            try {

                String titles="Event ID,Event Name,Event Time,Event Venue,Company Name,Total Amount,Received Amount,Payment Date,Cheque/DD No,Event TDS,Balance Amount";
                String[]arrTiltes=titles.split(",");





                FileOutputStream fileOut = new FileOutputStream("poi-test.xls");
                HSSFWorkbook workbook = new HSSFWorkbook();
                HSSFSheet worksheet = workbook.createSheet("POI Worksheet");


                int row=0;
                HSSFRow rowTitle = worksheet.createRow(row);

                // set  titles



                for(int i=0;i<arrTiltes.length;i++){
                    HSSFCell cellTitle=rowTitle.createCell(i);
                    cellTitle.setCellValue(arrTiltes[i]);


                }

                //setting values
                row++;
                for(Event dataValue:dataForGeneralReports){
                    HSSFRow rowValue = worksheet.createRow(row);


                        HSSFCell cell0 = rowValue.createCell(0);
                        cell0.setCellValue(dataValue.getEventID());

                        HSSFCell cell1 = rowValue.createCell(1);
                        cell1.setCellValue(dataValue.getEventName());

                        HSSFCell cell2 = rowValue.createCell(2);
                        cell2.setCellValue(dataValue.getEventTime());

                        HSSFCell cell3 = rowValue.createCell(3);
                        cell3.setCellValue(dataValue.getEventVenue());

                        HSSFCell cell4 = rowValue.createCell(4);
                        cell4.setCellValue(dataValue.getCompanyName());

                        HSSFCell cell5 = rowValue.createCell(5);
                        cell5.setCellValue(dataValue.getTotalAmount());

                        HSSFCell cell6 = rowValue.createCell(6);
                        cell6.setCellValue(dataValue.getReceivedAmount());

                        HSSFCell cell7 = rowValue.createCell(7);
                        cell7.setCellValue(dataValue.getPaymentDate());

                        HSSFCell cell8 = rowValue.createCell(8);
                        cell8.setCellValue(dataValue.getChequeDDNo());

                        HSSFCell cell9 = rowValue.createCell(9);
                        cell9.setCellValue(dataValue.getEventTDS());


                        HSSFCell cell10 = rowValue.createCell(10);
                        cell10.setCellValue(dataValue.getBalanceAmount());

                        row++;                      


                }



                workbook.write(fileOut);
                fileOut.flush();
                fileOut.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return "success";
        }