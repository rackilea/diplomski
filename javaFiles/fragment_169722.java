String str = textField_1.getText();

int[] vals = new int[3];

//you should check that your string is at least 3 characters long
String lower = str.toLowerCase(); //no need to equalsIgnorCase any more
for (int i = 0; i < 3; i++) { //loop over the first 3 characters
    char c = lower.charAt(i);
    if (c >= 'a' && c <= 'd') vals[i] = c - 'a' + 1; //populate the array
}
textField_2.setText("" + Integer.toString(vals[0]) + (vals[1]) + (vals[2]));