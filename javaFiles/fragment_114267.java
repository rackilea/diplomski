public static class Employee{
        String name;
        int numberOfDirectReport;
        String manager;
        List<Employee> directReport;

        public Employee(String name, int numberOfDirectReport, String manager) {
            this.name = name;
            this.numberOfDirectReport = numberOfDirectReport;
            this.manager = manager;
            this.directReport = new ArrayList<>();
        }

        public boolean add(Employee employee) {
            return directReport.add(employee);
        }

        public String toString(){
            return toString("");
        }

        public String toString(String prefix){
            String result = prefix + name + "\n";
            for(Employee child : directReport){
                result += child.toString(prefix+"\t");
            }
            return result;
        }
    }

    public static void main(String[] args) {
        // step 1: loading employees, to be replace by actual call to CSV reader
        HashMap<String, Employee> employees = new HashMap<>();
        employees.put("Bob", new Employee("Bob", 5, "Dave"));
        employees.put("Dave", new Employee("Dave", 2, "Alice"));
        employees.put("Sam", new Employee("Sam", 0, "Bob"));
        employees.put("Alice", new Employee("Alice", 2, null));

        // step 1.2: adding fake employees for test completion
        for(int i = 0; i < 4; i++){
            String name = "BobOtherReport"+i;
            employees.put(name, new Employee(name, 0, "Bob"));
        }
        employees.put("DaveOtherReport", new Employee("DaveOtherReport", 0, "Dave"));

        // step 2: link employees together
        for(Employee employee : employees.values()){
            if(employee.manager != null){
                // we retrieve the manager from the map and add this employee in the list inside it
                employees.get(employee.manager).add(employee);
            }
        }

        // step 3: display the top one. Either you loop on the map to find the one without manager, either you specify it
        System.out.println(employees.get("Alice").toString());
    }