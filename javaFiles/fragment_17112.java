Workbook wb = ...
try (OutputStream os = new FileOutputStream("sheet.xlsx")) {
    wb.write(os);
}
long len = new File("sheet.xlsx").length();
if (len > 1024_1024) {
    // upload
} else {
    // email
}