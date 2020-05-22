public Employee() {
    //note that in your code you didn't used the parameters anyway
    name = "Not Given";
    ppsNumber = "Not Givwn";
    employeeNumber = 0;
    numberOfEmployees = 0;
    earnings = 0;
    pay = 0;
    sales = 0;
}

public Employee(String name, String ppsNumber, int employeeNumber, int    numberOfEmployees, double earnings, double pay, double sales) {
    this.name = name;
    this.ppsNumber = ppsNumber;
    this.employeeNumber = employeeNumber;
    this.numberOfEmployees = numberOfEmployees;
    this.earnings = earnings;
    this.pay = pay;
    this.sales = sales;
}