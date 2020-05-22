List<? extends Number> method() { /* ... */ }

// Compiler error.
List<Number> list1 = method();
// OK, but yuk!
List<? extends Number> list2 = method();         
// OK, but the list gets copied.
List<Number> list3 = new ArrayList<Number>(method());