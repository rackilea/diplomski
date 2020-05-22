String str1 = "UNI:5";
String str2 = "UNI:" + getSomething();

private int getSomething() {
   return new Random().nextDouble() > 0.5 ? 1 : 5;
}