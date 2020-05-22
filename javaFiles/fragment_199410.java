public boolean addStaff(Employe employe){
        List<Employee> tempList = Arrays.asList(this.employees);
    boolean added = tempList.add(employe);
    this.employees = tempList.toArray(this.employees);
    return added;
 }