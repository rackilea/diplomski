class EmployeeDetails {
      private Map<String, Employee> Employee;
}

class Employee {
     private Long id;
     private String name;
     private String jobRole;
     private Contact contact;
     private List<String> peers;
 }

 class Contact {
    private String phone;
    private String address;
  }