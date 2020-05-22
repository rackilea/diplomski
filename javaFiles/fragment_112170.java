SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
f.setLenient(false);  <-- by default SimpleDateFormat allows 20010132
try {
   f.parse(str);
   // good
} catch (ParseExcepton e) {
   // bad
}