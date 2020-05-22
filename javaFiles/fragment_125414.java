@MappedSuperclass
abstract public class Person { 
  @Column(name="PERSON_NAME")
  private String name; 
}
@Entity
public class Employee extends Person {
        @Column(name="EMPLOYEE_NAME")
        private String name;
}