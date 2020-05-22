String mNameStr = s.toString();
String finalStr = "";
if (!mNameStr.equals("")) {
 String[] strArray = mNameStr.split("[\\s']");
 if (strArray.length > 0) {
  int i = 0;
  for (i = 0; i < strArray.length - 1; i++) {
   finalStr += capitalize(strArray[i]) + " ";
  }
  finalStr += capitalize(strArray[i]);
  Log.d("finalStr==> ", finalStr);
 }
}
if (!finalStr.equals(prevString)) {
 prevString = finalStr;
 editText.setText(finalStr.toString());
 editText.setSelection(finalStr.length());
}