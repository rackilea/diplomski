Workbook workbook = new Workbook();
//Get the first worksheet (default sheet)    
Worksheet worksheet = workbook.getWorksheets().get(0);
Cells cells = worksheet.getCells();

//Input fraction values to the cells.
Cell cell1 = cells.get("A1");
double val1 = 1/2d;
cell1.putValue(val1);

Cell cell2 = cells.get("A2");
double val2 = 19/4d;
cell2.putValue(val2);

Cell cell3 = cells.get("A3");
double val3 = 5/3d;
cell3.putValue(val3);


//Create a style object.
Style style = workbook.createStyle();
//Set the numbers formatting
style.setCustom("# ?/?");

//Apply style to the cells.
cell1.setStyle(style);
cell2.setStyle(style);
cell3.setStyle(style);


//Apply formula to a cell
Cell cell4 = cells.get("B1");
cell4.setFormula("=TEXT(A1,\"0/#0\")");

//Even you may directly put numeric value as text value.
Cell cell5 = cells.get("C1");
cell5.putValue("1/2", false);
//Note: if you double cliked in the cell, it will be converted to numeric DateTime notations.


//Save the file
workbook.save("f:\\files\\out1.xls");