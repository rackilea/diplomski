// A simple mutable type with get/setValue doing the obvious thing
MutableType x = new MutableType();
x.setValue(5);
MutableType y = x;
x.setValue(10);
System.out.println(y.getValue());