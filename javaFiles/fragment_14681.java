public class Employee {
    private final String name ;
    private final boolean active ;

    public Employee(String name, boolean active) {
        this.name = name ;
        this.active = active ;
    }

    public String getName() {
        return name ;
    }

    public boolean isActive() {
        return active ;
    }
}