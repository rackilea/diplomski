Map<Integer, Object[]> data = new TreeMap<Integer, Object[]>();  
  int i = 1;
    for(Row r1 : sheet) {
      //This is for empty cell value
       String c3;
       if(r1.getCell(column_index_3) == null)
         c3 = " ";
       else
         c3 = r1.getCell(column_index_3).getStringCellValue();
       data.put(i, new Object[]{ r1.getCell(column_index_1).getStringCellValue(), r1.getCell(column_index_2).getStringCellValue(), c3});
        i++;
}
Set<Integer> keyset = data.keySet(); 
            int rownum = 0; 
            for (Integer key : keyset) { 
                // this creates a new row in the sheet 
                Row row1 = sheet1.createRow(rownum++); 
                Object[] objArr = data.get(key); 
                int cellnum = 0; 
                for (Object obj : objArr) { 
                    // this line creates a cell in the next column of that row 
                    Cell cell = row1.createCell(cellnum++); 
                    if (obj instanceof String) 
                        cell.setCellValue((String)obj); 
                    else if (obj instanceof Integer) 
                        cell.setCellValue((Integer)obj);

                } 
            } 
try { 
            // this Writes the workbook gfgcontribute 
            FileOutputStream out = new FileOutputStream(new File("E:\\Dharshan/test.xlsx")); 
            wb.write(out); 
            out.close(); 
            System.out.println("test.xlsx written successfully on disk."); 
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
}