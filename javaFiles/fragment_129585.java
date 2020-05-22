class Foo {
  private static Bar someStaticField = ...;

  public static setStaticFieldIfNull(Bar newValue) {
      if (someStaticField == null) {
         someStaticField = newValue;