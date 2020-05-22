wb = new XSSFWorkbook(new File(xlsmFile));
XSSFSheet s = wb.getSheet("TWO");
XmlObject[] subobj = s.getCTWorksheet().selectPath(declares+
            " .//mc:AlternateContent/mc:Choice/main:controls/mc:AlternateContent/mc:Choice/main:control");

String targetButton = "Button 2";
int rowsDown = 10;

for (XmlObject obj : subobj) {
    XmlCursor cursor = obj.newCursor();
    cursor.push();
    String attrName = cursor.getAttributeText(new QName("name"));
    if (attrName.equals(targetButton)) {
        cursor.selectPath(declares+" .//main:from/xdr:row");
        if (!cursor.toNextSelection()) {
            throw new Exception();
        }
        int newRow = Integer.parseInt(cursor.getTextValue()) + rowsDown;
        cursor.setTextValue(Integer.toString(newRow));

        cursor.pop();
        cursor.selectPath(declares+" .//main:to/xdr:row");
        if (!cursor.toNextSelection()) {
            throw new Exception();
        }
        newRow = Integer.parseInt(cursor.getTextValue()) + rowsDown;
        cursor.setTextValue(Integer.toString(newRow));
    }
    cursor.dispose();
}