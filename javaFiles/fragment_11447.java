double parsedValue = Double.parseDouble(one.getText().toString());

double one_thing;
double two_thing;
if (one_spinner.getSelectedItem().toString().equals("one")) {
   one_thing = parsedValue;
   two_thing = one_thing * 5;
} else {
   two_thing = parsedValue;
   one_thing = two_thing / 5;
}