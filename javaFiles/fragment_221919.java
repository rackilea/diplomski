int selectionEnd = et.getSelectionEnd();
String text = et.getText().toString();
if (selectionEnd >= 0) {
    // gives you the substring from start to the current cursor
    // position
    text = text.substring(0, selectionEnd);
}
String delimiter = " ";
int lastDelimiterPosition = text.lastIndexOf(delimiter);
String lastWord = lastDelimiterPosition == -1 ? text : 
    text.substring(lastDelimiterPosition + delimiter.length());
// do whatever you need with the lastWord variable