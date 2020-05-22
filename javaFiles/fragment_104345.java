public class Employees /*implements List<Employees>*/ {
    private static final long serialVersionUID = 1L;
    private LinkedList<Employee> employees;

    public Employees(){ 
        employees = new LinkedList<Employee>();
    }

    public Employees(Employees w){
        employees = new LinkedList<Employee>(w);
    }

    public void add(Employee w){
        employees.add(w);
    }

    public Employees clone() {
        return employees.clone();
    }

    // add more methods as you need them (like remove, get, size, etc)
}