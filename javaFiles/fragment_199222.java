WorkbookSettings ws = new WorkbookSettings();
ws.setLocale(new Locale("en", "EN"));
WritableWorkbook workbook = null;
File newFile = new File(dir.getPath() + "\\" + fileName);
workbook = Workbook.createWorkbook(newFile, ws);
WritableSheet s = workbook.createSheet("mySheet", 0);
for (int i = 1; i <= <columncount>; ++i) {
Label l = new Label(i - 1, 0, <columnname>, cf);
s.addCell(l);
}

for (int j = 1; j <= <rowcount>; j++) {
    for (int i = 1; i <= <columncount>; i++) {
        Label m = new Label(i - 1, j, <rowvalue>, cf);
        s.addCell(m);
    }
}
workbook.write();
workbook.close();`