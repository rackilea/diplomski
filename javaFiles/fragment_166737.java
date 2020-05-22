final String sheetName = "somesheet";
Integer index = null;
final Sheet[] sheets = workbook.getSheets();            
for(int i=0;i<sheets.length && index == null; i++) {
    if(sheets[i].getName().equals(sheetName)) {
        index = i;                  
    }
}