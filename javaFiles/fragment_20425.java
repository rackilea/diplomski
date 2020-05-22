String string ="2165%";

double d = Double.parseDouble(string.substring(0, string.length()-1));
if (d != 0) {
   d = d / 100;
}