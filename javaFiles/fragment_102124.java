public enum EmployeeStatus {FULL_TIME, PART_TIME, CONTRACT}

   public enum SalaryRate {JUNIOR, SENIOR, MANAGER, EXECUTIVE}

   @Entity public class Employee {
       public EmployeeStatus getStatus() {...}
       ...
       @Enumerated(STRING)
       public SalaryRate getPayScale() {...}
       ...
   }