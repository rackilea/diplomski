Workbook wb = new HSSFWorkbook();
Sheet personSheet = wb.createSheet("PersonList");
Row headerRow = personSheet.createRow(0);
Cell nameHeaderCell = headerRow.createCell(0);
Cell addressHeaderCell = headerRow.createCell(1);

String sql = "select name, address from person_table";
PrepareStatement ps =  connection.prepareStatement(sql);
ResultSet resultSet = ps.executeQuery();    

int row = 1;
while(resultSet.next()) {
    String name = resultSet.getString("name");
    String address = resultSet.getString("address");

    Row dataRow = personSheet.createRow(row);

    Cell dataNameCell = dataRow.createCell(0);
    dataNameCell.setCellValue(name);

    Cell dataAddressCell = dataRow.createCell(1);
    dataAddressCell.setCellValue(address);

    row = row + 1;
}

String outputDirPath = "D:/PersonList.xls";
FileOutputStream fileOut = new FileOutputStream(outputDirPath);
wb.write(fileOut);
fileOut.close();