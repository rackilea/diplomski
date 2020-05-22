Double d;
String string = "5%";
if (string.endsWith("%")) {
    string.replace("%", "");
    d = Double.parseDouble(string);
    d /= 100;
}