myClass A=new myClass();
A.add(1);    A.add(2);    A.add(3);
myClass B=new myClass();
B.add(3);    B.add(1);    B.add(2);   B.add(4);
A.isSubsetOf(B);
//This will answer true