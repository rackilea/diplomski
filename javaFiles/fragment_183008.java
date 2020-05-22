//Provided you have overriden the equals() method
          List<Employee> employeeList = new ArrayList<Employee>();
          Set<Employee> employeeSet = new HashSet<Employee>(employeeList);

          int dupEntries = employeeList.size() - employeeSet.size();
          System.out.println("Dup Entries : "+dupEntries);