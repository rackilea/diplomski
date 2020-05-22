void main() {
  Foo a = new Foo();
  String i = a.get();
  String j = i + " rocks"; // creates a new string
  i = "Summer"; // now points to another string
  System.out.println(a.get()); // still prints "Winter"
}