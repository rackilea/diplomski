MyClass[] n = new MyClass [10];

for (int i = 0; i < 5; i++) {
  n[i] = new MyClass();
  n[i].setNumber(i);
  n[i].printNumber();
}