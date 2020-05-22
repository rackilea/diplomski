public static void main(String[] args) {
    // TODO Auto-generated method stub

    List<Employee> employees = new ArrayList<>();
    employees.add(new Employee("a",20,100));
    employees.add(new Employee("a",21,100));
    employees.add(new Employee("a",35,100));
    employees.add(new Employee("a",32,100));


    Map<Double,Integer> ageGroup= employees.stream().collect(Collectors.groupingBy(e->Math.ceil(e.age/10.0),Collectors.summingInt(e->e.salary)));
    System.out.println(ageGroup);
}

public static class Employee {
    public Employee(String name, int age, int salary) {
        super();
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public String name;
    public int age;
    public int salary;

}