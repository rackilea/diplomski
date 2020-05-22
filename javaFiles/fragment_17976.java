Employee employee = null;
if(firstName != null && lastName != null && sex != null){
    employee = new Employee(firstName, lastName, sex);
} else if(firstName != null && lastName != null && salutation != null){
    employee = new Employee(firstName, lastName, salutation );
} else {
  .....
}