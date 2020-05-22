public class HourlyEmployee extends Employee {

    private double hourlySalary;

    public HourlyEmployee(String name, double hourlySalary) {
        super(name, hourlySalary * 200);
        this.hourlySalary = hourlySalary;
    }
}