public class Employee 
{
    //...
    Pay pay;

    // EmployeeID constructor
    public Employee(String empID)
    {
        this.employeeID = empID;
    }

    // EmployeeID constructor
    public Employee(String empID, Pay pay)
    {
        this(empID);
        this.pay = pay;
    }

    public void setPay(Pay pay) {
        this.pay = pay;
    }

    public Pay getPay() {
        return pay
    }
    //...
}