public boolean addEmployee( employee emp){

    if (first == null)  {
        first = new EmployeeNode(emp);
        return true;
    }
    else {  // first must != null
        EmployeeNode temp = new EmployeeNode(emp); //create the new employee
        temp.link = first; // link the new employee to the old employee at the front of the list

        first = temp; //update the new front of list to be the new employee
        return true;
    }
}