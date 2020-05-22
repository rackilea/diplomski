// get the sheet document using UnoRuntime
XSpreadsheetDocument sheetDoc = ...;
// get an object containing all sheets
XSpreadsheets sheets = sheetDoc.getSheets();
// get the sheets names
String[] sheetnames = sheets.getElementNames();