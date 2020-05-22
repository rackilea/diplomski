while(rs.next()){
      int id  = rs.getInt("id");
      int age = rs.getString("name");
      String first = rs.getInt("amount");
      // Adding data here
      Row newRow = worksheet.createRow(worksheet.getLastRowNum() + 1);
      newRow.createCell(0).setCellValue(id);
      newRow.createCell(1).setCellValue(age);
      newRow.createCell(2).setCellValue(first);
}