Integer i1, i2, i3;
i1 = 100; //it will call Integer with value of 100 from cache
i2 = Integer.valueOf(100); //it will call Integer with value of 100 from cache
i3 = new Integer(100); //creates a new instance
System.out.println(i1 == i2); //true
System.out.println(i1 == i3); //false
System.out.println(i1.equals(i2)); //true
System.out.println(i1.equals(i3)); //true