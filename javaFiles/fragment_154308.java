int result;
int left = Integer.parseInt(splitStrings[0]);
String op = splitStrings[1];
int right = Integer.parseInt(splitStrings[2]);
if(op.equals("+")){
    result = left + right;
}
text.setText("" + result);