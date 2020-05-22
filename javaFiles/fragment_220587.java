Employee e1 = new Employee("Jon", "Smith", 30);
Employee e2 = new Employee("Jon", "Smith", 35);
Employee e3 = new Employee(new String("Jon"), new String("Smith"), 35);

System.out.println(e1.equals(e2));  // true
System.out.println(e1.equals(e3));  // false