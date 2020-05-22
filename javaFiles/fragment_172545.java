public class Salary {
    private static final long MAX_SALARY = Long.MAX_VALUE;
    private final String name;
    private final long salary;

    /**
      * Create highest possible salary of the given name
      */
    public Salary(String name) {
        this(name, MAX_SALARY);
    }

    /**
      * Create a Salary of the given name and value
      */
    public Salary(String name, long salary) {
        this.name = name; // TODO add null and integrity checks
        this.salary = salary; 
    }
}