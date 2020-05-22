@Entity
public class Employee {

@TableGenerator(name = "employee_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1,table="id_gen")
@Id
@GeneratedValue(generator = "employee_gen", strategy = GenerationType.TABLE)
private int idEmployee;

private String firstName;
private String lastName;
private int salary;

public int getIdEmployee() {
    return idEmployee;
}

public void setIdEmployee(int idEmployee) {
    this.idEmployee = idEmployee;
}

// gettrs and setters

@PrePersist
public void methodInvokedBeforePersist() {
    System.out.println("Invoked before persisting employee");
}

@PostPersist
public void methodInvokedAfterPersist() {
    System.out.println("Invoked after persisting employee");
}

@PreUpdate
public void methodInvokedBeforeUpdate() {
    System.out.println("Invoked before updating employee");
}

@PostUpdate
public void methodInvokedAfterUpdate() {
    System.out.println("Invoked after updating employee");
}

@PreRemove
public void methodInvokedBeforeRemove() {
    System.out.println("Invoked before removing employee");
}

@PostRemove
public void methodInvokedAfterRemove() {
    System.out.println("Invoked after removing employee");
}

  }