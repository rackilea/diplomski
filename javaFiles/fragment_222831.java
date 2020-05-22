public void exportExcel(){          
    FacesContext fc = FacesContext.getCurrentInstance();
    ExternalContext ec = fc.getExternalContext();       
    String filename = "ExportList.xlsx";

    XSSFWorkbook workbook = new XSSFWorkbook(); 
    XSSFSheet sheet = workbook.createSheet("Export Data");  

    int rownum = 0;

    Row headRow = sheet.createRow(rownum++);    

    Cell cell1 = headRow.createCell(0);
    Cell cell2 = headRow.createCell(1);
    Cell cell3 = headRow.createCell(2);
    Cell cell4 = headRow.createCell(3);

     cell1.setCellValue("Name");                 
     cell2.setCellValue("Age");             
     cell3.setCellValue("Sex");     


     for(Bean view : list){
         int cellnum = 0;
         Row row = sheet.createRow(rownum++);

         row.createCell(cellnum++).setCellValue(view.name);              
         row.createCell(cellnum++).setCellValue(view.age);              
         row.createCell(cellnum++).setCellValue(view.sex);      
     }
   try{
      ec.responseReset();         
      ec.setResponseContentType("text/xlsx");
      ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");     

      //to align column vertically
      sheet.autoSizeColumn(0);
      sheet.autoSizeColumn(1);
      sheet.autoSizeColumn(3); 

      workbook.write(ec.getResponseOutputStream()); 

      fc.responseComplete();                    
   } 
  catch (Exception e){
            e.printStackTrace();
  }
  }