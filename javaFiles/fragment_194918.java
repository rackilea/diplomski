/**
     * @author revanthreddya
     *
     */
    package com.playground.excel;

    public class ExcelUtils 
    {
        private Workbook wb;
         private Sheet ws;

         public ExcelUtils(String file, String sheet) {
             try {

                   if (file.indexOf("xlsx") < 0) { 
                    wb = new HSSFWorkbook(new FileInputStream(new File(file)));
                    ws = wb.getSheet(sheet);
                   } else { 
                    wb = new XSSFWorkbook(new FileInputStream(new File(file)));
                    ws = (XSSFSheet) wb.getSheet(sheet);
                   }
                  } catch (IOException io) {
                   System.err.println("Invalid file '" + file
                     + "' or incorrect sheet '" + sheet
                     + "', enter a valid one");
                  }
        }


         public int rowCount(){
                return ws.getLastRowNum();
             }


         public String getCell(int rowIndex, int columnIndex) {
              Cell cell = null;

              try {
                cell = ws.getRow(rowIndex).getCell(columnIndex);
              } catch (Exception e) {
               System.err.println("The cell with row '" + rowIndex + "' and column '"
                 + columnIndex + "' doesn't exist in the sheet");
              }
              return new DataFormatter().formatCellValue(cell);
             }


    }



public class TestCase {

     @Test(dataProvider="access")
     public void AADLoginLogoutTest(String test, String username, String password) throws IOException 
     {
          System.out.println(" test :"+test+"  user "+username+"  password:"+  password); 
     }


     @DataProvider(name = "access")
     public Object[][] access() throws Exception {

      ExcelUtils userD= new ExcelUtils("input.xlsx", "Actions");

      ArrayList<Object> paraList = new ArrayList<Object>();

      int i = 1;
      int totalRows = userD.rowCount();
      System.out.println("TotalRows: "+totalRows);
      while (i < totalRows) {

       Object[] args = new Object[3];
       args[0] = userD.getCell(i, 0);
       args[1] = userD.getCell(i, 1);
       args[2] = userD.getCell(i, 2);

       paraList.add(args);

       i++;
      }

      Object[][] argsData = new Object[paraList.size()][];
      for (i = 0; i < paraList.size(); i++)
       argsData[i] = (Object[]) paraList.get(i);
      return argsData;
     }
}