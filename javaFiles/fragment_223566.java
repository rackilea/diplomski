/* remove void */ 
Business(String name, String phone, int employees){ 
    System.out.printf("%s %s %d\n", name, phone, employees);

    this.name = name;
    this.phone = phone;
    this.employees = employees;
    this.age = 0;

    System.out.println("In constructor!");
    printVals();
}