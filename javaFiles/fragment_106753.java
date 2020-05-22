-injars       calc.jar
-outjars      calc_obf.jar
-libraryjars  <java.home>/lib/rt.jar
-keep class Calc {
  public static void main(java.lang.String[]);
}