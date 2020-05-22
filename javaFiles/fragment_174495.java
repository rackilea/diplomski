public class Employee {
    private String empId;

    public Employee() {

    }

    // Methods

    public void setEmpId(String empId) {
        this.empId = empId;
    }
    public static void main(String[] args) {
        Employee a = new Employee(); //No error
        a.setEmpId("SOMEX007");

    }
}