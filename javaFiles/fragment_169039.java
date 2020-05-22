private String firstName;

    List<String> employees = null;


    public Employee(@Value("${Employee.name}") String name) {
        this.firstName = name;
        this.employees = Arrays.asList(firstName);
    }