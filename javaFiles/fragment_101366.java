User obj = new Manager();
User obj2 = new SalesMan();
System.out.println(obj instanceof Manager); // true
System.out.println(obj instanceof SalesMan);// false

System.out.println(obj2 instanceof Manager); // false
System.out.println(obj2 instanceof SalesMan);// true