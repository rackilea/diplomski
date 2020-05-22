public class EmployeeLoggerListener {

    @PrePersist
    public void methodInvokedBeforePersist(Employee emp) {
        System.out.println("persisting employee with id = " + emp.getIdEmployee());
    }

    @PostPersist
    public void methodInvokedAfterPersist(Employee emp) {
        System.out.println("Persisted employee with id = " + emp.getIdEmployee());
    }

    @PreUpdate
    public void methodInvokedBeforeUpdate(Employee emp) {
        System.out.println("Updating employee with id = " + emp.getIdEmployee());
    }

    @PostUpdate
    public void methodInvokedAfterUpdate(Employee emp) {
        System.out.println("Updated employee with id = " + emp.getIdEmployee());
    }

    @PreRemove
    private void methodInvokedBeforeRemove(Employee emp) {
        System.out.println("Removing employee with id = " + emp.getIdEmployee());
    }

    @PostRemove
    public void methodInvokedAfterRemove(Employee emp) {
        System.out.println("Removed employee with id = " + emp.getIdEmployee() );
    }

 }