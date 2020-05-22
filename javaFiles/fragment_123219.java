WritableWorkbook workbook = Workbook.createWorkbook(out);

// ...

workbook.close();
out.flush();
out.close();