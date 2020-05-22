public class Age 
{
    private int age = -1;
    private double salary;
    private double savings;

public Age() {
}
public Age(double salary, double savings) {
    super();
    this.salary = salary;
    this.savings = savings;
}
public double getSalary() {
    return salary;
}
public void setSalary(double salary) {
    this.salary = salary;
}
public void setSavings(double savings) {
    this.savings = savings;
}
public double getSavings() {
    return savings;
}
public int getAge() {
    computeAge();
    return age;
}

public void computeAge()
{
    double a = 12*(0.16 + 0.20) * salary;
    double b = 2*a;
    if (a < savings)
        // only worked for less than one year
        age = 22;
    else if(a >= savings && b > salary )
        // age>22&&age<=35
        age = 23;
    else
        System.out.println("The person hasn't started working.");
}