import org.apache.poi.ss.usermodel.*;

import java.util.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;

class GetDataFromExcel {

 public static void main(String[] args) throws Exception {

  Workbook workbook = WorkbookFactory.create(new FileInputStream("ExcelExample.xlsx"));

  DataFormatter dataFormatter = new DataFormatter();
  FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();

  Sheet sheet = workbook.getSheetAt(0);

  int headerRowNum = sheet.getFirstRowNum();

  // collecting the column headers
  TreeMap<Integer, String> colHeaders = new TreeMap<Integer, String>();
  Row row = sheet.getRow(headerRowNum);
  for (Cell cell : row) {
   int colIdx = cell.getColumnIndex();
   String value = dataFormatter.formatCellValue(cell, formulaEvaluator);
   colHeaders.put(colIdx, value);
  }

System.out.println(colHeaders);

  // collecting the column values
  Map<Integer, List<String>> colValues = new HashMap<Integer, List<String>>();
  for (Map.Entry<Integer, String> entry : colHeaders.entrySet()) {
   int colIdx = entry.getKey();
   List<String> values = new ArrayList<String>();
   for (int r = headerRowNum + 1; r <= sheet.getLastRowNum(); r++) {
    row = sheet.getRow(r); if (row == null) row = sheet.createRow(r);
    Cell cell = row.getCell(colIdx); if (cell == null) cell = row.createCell(colIdx);
    String value = dataFormatter.formatCellValue(cell, formulaEvaluator);
    values.add(value);
   }
   colValues.put(colIdx, values);
  }

System.out.println(colValues);

  // printing it to files
  Map.Entry<Integer, String> firstColEntry = colHeaders.firstEntry();
  Map.Entry<Integer, String> entry = colHeaders.higherEntry(firstColEntry.getKey());
  while (entry != null) {
   String fileName = "./" + entry.getValue() + ".txt";
   PrintWriter writer = new PrintWriter(new File(fileName));
   String firstValue = firstColEntry.getValue();
   String value = entry.getValue();
   writer.println(firstValue + "\t" + value);
   List<String> firstValues = colValues.get(firstColEntry.getKey());
   List<String> values = colValues.get(entry.getKey());
   int rowCount = (firstValues.size() > values.size())?firstValues.size():values.size();
   for (int r = 0; r < rowCount; r++) {
    firstValue = (firstValues.size()>r)?firstValues.get(r):"";
    value = (values.size()>r)?values.get(r):"";
    writer.println(firstValue + "\t" + value);
   }   
   writer.close();  
   entry = colHeaders.higherEntry(entry.getKey());
  }

  workbook.close();
 }
}