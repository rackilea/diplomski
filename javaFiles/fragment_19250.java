class MyClass {}
class Class2 implements MyClass {}
class Class3 implements MyClass {}

void main() {
  bool value = true;
  int i = (value == true) ? 0 : 1;
  List<MyClass> newInstance = [Class2(), Class3()];
}