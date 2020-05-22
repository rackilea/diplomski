public double getDoubleFromString(String string) {
   NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
   Number number;
   double d;
   try {
      number = format.parse(string);
      d = number.doubleValue();
   } catch (Exception e) {
      e.printStackTrace();
      d = Double.NaN;
   }
   return d;
}