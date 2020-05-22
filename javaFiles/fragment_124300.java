// in one class
ClassA classA = new ClassA(); // package1.ClassA
another.test(classA);

// calls in another class
public void test(Object o) {
   if (o instanceof ClassA) // package2.ClassA => false