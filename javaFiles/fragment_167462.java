float number = 0;
try{
   number = Float.valueOf(edt.getText().toString());
} catch (NumberFormatException e) {
   e.printStackTrace();
}