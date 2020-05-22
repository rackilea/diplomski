WritableSheet sheet2 = copy.getSheet(1); 
WritableCell cell = sheet2.getWritableCell(1, 2); 

if (cell.getType() == CellType.LABEL) 
{ 
  Label l = (Label) cell; 
  l.setString("modified cell"); 
}
copy.write(); 
copy.close();
workbook.close();