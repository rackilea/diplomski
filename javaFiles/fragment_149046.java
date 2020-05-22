String n1 = e1.getText().toString();
String n2 = e2.getText().toString();
String n3 = e3.getText().toString();

if (!isNumeric(n1) || !isNumeric(n2) || !isNumeric(n3))
   return "Wrong input";
else
   //   Do your math here