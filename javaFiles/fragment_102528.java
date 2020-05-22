try {
    Class.forName("driverName");
    Connection con = DriverManager.getConnection("url", "user", "pass");
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("Select * from tablename");
    HSSFWorkbook workbook = new HSSFWorkbook();
    HSSFSheet sheet = workbook.createSheet("lawix10");
    HSSFRow rowhead = sheet.createRow((short) 0);
    rowhead.createCell((short) 0).setCellValue("CellHeadName1");
    rowhead.createCell((short) 1).setCellValue("CellHeadName2");
    rowhead.createCell((short) 2).setCellValue("CellHeadName3");
    int i = 1;
    while (rs.next()){
        HSSFRow row = sheet.createRow((short) i);
        row.createCell((short) 0).setCellValue(Integer.toString(rs.getInt("column1")));
        row.createCell((short) 1).setCellValue(rs.getString("column2"));
        row.createCell((short) 2).setCellValue(rs.getString("column3"));
        i++;
    }
    String yemi = "g:/test.xls";
    FileOutputStream fileOut = new FileOutputStream(yemi);
    workbook.write(fileOut);
    fileOut.close();
    } catch (ClassNotFoundException e1) {
       e1.printStackTrace();
    } catch (SQLException e1) {
        e1.printStackTrace();
    } catch (FileNotFoundException e1) {
        e1.printStackTrace();
    } catch (IOException e1) {
        e1.printStackTrace();
    }