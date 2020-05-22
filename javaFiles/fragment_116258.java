public class Person {
    private Department dep;

    public void setDepartment(Department dep) {
        this.dep = dep;
    }
}

public class Department { 
    private String name;
    public void setName(String name) {
        this.name = name;
    }
}