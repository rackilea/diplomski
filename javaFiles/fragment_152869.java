String val = "123.123 ";
float f = Float.parseFloat(val);

String val = "123,123 "; // if other char(like comma) come, you can also write a regex to replace those set of char
val = val.replace(",",".");// assuming comma is used for decimals
float f = Float.parseFloat(val);