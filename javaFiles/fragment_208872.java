Employee employee = new Employee();
employee.setName("null");
employee.setSurname("pointer");
Manager manager = new Manager();
manager.setName("null");
manager.setSurname("pointer");
manager.setBonus(10);
System.out.println(manager.equals(employee));