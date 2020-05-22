class Employee {

    private String name;
    private int workingHours;
    private final boolean IS_PART_TIME_EMP;

    public Employee(String name, int workingHours) {
        this.name = name;
        this.workingHours = workingHours;
        this.IS_PART_TIME_EMP = false;
    }

    public Employee(String name) {
        this.name = name;
        this.IS_PART_TIME_EMP = true;
    }

    public String getName() {
        return name;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public boolean isPartTimeEmployee() {
        return IS_PART_TIME_EMP;
    }
}