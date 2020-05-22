Parent p = new Parent();
Child c = new Child(); 
Parent pc = new Child();

System.out.println(c.foo); // will print Child
System.out.println(p.foo); // will print Parent
System.out.println(pc.foo); // will print Parent
System.out.println(((Child)pc).foo) // will print Child