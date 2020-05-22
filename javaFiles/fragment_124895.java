public void alpha1()
   {
       Collections.sort(list, new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
          return o1.getLastName().compareTo(o2.getLastName());
        }
      });

      ListIterator<Employee> iterate = list.listIterator();
      while (iterate.hasNext())
      {
        emp = iterate.next();
        System.out.println("First Name" + "\t" + "Last Name" + "\t" + "Salary");
      }
    }