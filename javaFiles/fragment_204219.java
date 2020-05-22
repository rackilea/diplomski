public class MyJSON {
    private MyStatus status;
    private List<EmployeeStatus> employeeStatus = new ArrayList<>();
    public MyJSON(String status, String message) {
        this.status = new MyStatus(status, message);
    }
    public void addEmployeeStatus(int id, String name) {
        this.employeeStatus.add(new EmployeeStatus(id, name));
    }
    public MyStatus getStatus() {
        return this.status;
    }
    public List<EmployeeStatus> getEmployeeStatus() {
        return this.employeeStatus;
    }
}