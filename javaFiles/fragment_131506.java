FileOutputStream outputStream=new FileOutputStream(new File("Output.ser"));
ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
ArrayList<Employee> employees = new ArrayList<Employee>();
employees.add(employee);
employees.add(employee2);
employees.add(employee3);
employees.add(employee4);
objectOutputStream.writeObject(employees);
objectOutputStream.close();