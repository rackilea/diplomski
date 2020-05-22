Outer o1 = new Outer(1);
Outer o2 = new Outer(2);
Outer.Inner in1 = o1.new Inner();
Outer.Inner in2 = o2.new Inner();

in1.printOuterID();
in2.printOuterID();