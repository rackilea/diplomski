void foo() {
  String str = "hello";
  int constant = 1;
  boolean boolValue = true;
  a(str, constant);
  b(str, boolValue);

  constant = 2;
  boolValue = false;
  a(str, constant);
  b(str, boolValue);
}