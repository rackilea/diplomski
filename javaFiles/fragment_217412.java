public class TestJacksonMixin {

    /* 3rd party */
    public static class Employee {
        public String name;
        public Address address;
    }

    /* 3rd party */
    public static class Address {
        public String city;
    }

    /* Jackon Module for Employee */
    public static class EmployeeModule extends SimpleModule {
        abstract class EmployeeMixin {
            @JsonUnwrapped
            public Address address;
        }

        public EmployeeModule() {
            super("Employee");
        }

        @Override
        public void setupModule(SetupContext context) {
            setMixInAnnotation(Employee.class, EmployeeMixin.class);
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        Employee emp = new Employee();
        emp.name = "Bob";
        emp.address = new Address();
        emp.address.city = "New York";

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new EmployeeModule());

        System.out.println(mapper.writeValueAsString(emp));
    }
}