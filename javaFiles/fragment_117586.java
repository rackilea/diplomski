<T> void something(Adder<T> adder, T a, T b) {
  System.out.println(adder.add(a, b));
}

something(new StringAdder(), "Hello", "World");
something(new IntegerAdder(), 1, 2);