double one_thing;
double two_thing;
if (one_spinner.getSelectedItem().toString().equals("one")) {
   one_thing = Double.parseDouble(one.getText().toString());
   two_thing = one_thing * 5;
} else {
   two_thing = Double.parseDouble(one.getText().toString());
   one_thing = two_thing / 5;
}