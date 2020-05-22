private String addNumbers() {
int number1;
int number2;
int number3;
int number4;
if (editText3.getText().toString() != "" && editText3.getText().length() > 0) {
    number1 = Integer.parseInt(editText3.getText().toString());
} else {
    number1 = 0;
}
if (editText4.getText().toString() != "" && editText4.getText().length() > 0) {
    number2 = Integer.parseInt(editText4.getText().toString());
} else {
    number2 = 0;
}
if (editText6.getText().toString() != "" && editText6.getText().length() > 0) {
    number3 = Integer.parseInt(editText6.getText().toString());
} else {
    number3 = 0;
}
if (editText8.getText().toString() != "" && editText8.getText().length() > 0) {
    number4 = Integer.parseInt(editText8.getText().toString());
} else {
    number4 = 0;
}

int sum = (number1 * 2) + (number2 * 4) + (number3 * 2) + (number4 * 2);
if (sum > 6) sum = 6;
prefs.edit().putString("result", sum.toString()).commit();
return sum + "";

  } 
}