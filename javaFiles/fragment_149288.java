Test obj1 = new Test(100, 22);
Test obj2 = new Test(100, 22);
Test obj3 = obj2;

System.out.println(obj1.equals(obj2)); // true
System.out.println(obj1 == obj2);      // false
System.out.println(obj2 == obj3);      // true
System.out.println(obj1.equals(obj3)); // true