function myFunction() {
  sheet = SpreadsheetApp.getActiveSpreadsheet().getSheets()[0];
  range = 'A1:A5';
  myFormulas = sheet.getRange(range).getFormulas();
  sheet.getRange(range).setFormulas(myFormulas);
 }