Object o1 = new Object();
 Object o2 = o1;

 o1 == o2; //true

 o2 = new Object();

 o1 == o2 // false