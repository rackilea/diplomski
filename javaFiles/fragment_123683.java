NumberFormat formatter = NumberFormat.getInstance();
String result = null;
if (num % 1000000 == 0 && num != 0) {
   result = formatter.format(num / 1000000) + "M";
} else if (num % 1000 == 0 && num != 0) {
   result = formatter.format(num / 1000) + "K";
} else {
   result = formatter.format(num);
}