ByteArrayOutputStream baos = new ByteArrayOutputStream();
WritableWorkbook workbook = Workbook.createWorkbook(baos);

// ...

workbook.close();
out.write(baos.toByteArray());
out.flush();
out.close();