JTextComponent testingArea = new JTextPane();
....
int caretPos = testingArea.getCaretPosition();
int rowNum = (caretPos == 0) ? 1 : 0;
for (int offset = caretPos; offset > 0;) {
    offset = Utilities.getRowStart(textArea, offset) - 1;
    rowNum++;
}
System.out.println("Row: " + rowNum);