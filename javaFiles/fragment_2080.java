for(int i=0; rs.next(); i++)
{
    HSSFRow row = sheet.createRow(i);
    row.createCell(0).setCellValue(rs.getString("EXCEPTION_MESSAGE"));
    row.createCell(1).setCellValue(rs.getString("EXCEPTION_COUNT"));
}