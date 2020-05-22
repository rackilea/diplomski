public class EmpSort {
    static final Comparator<Employee> comp1 = new Comparator<Employee>() {
        public int compare(Employee e1, Employee e2) {
            // use prperty1 to sort
            return e2.hireDate().compareTo(e1.hireDate());
        }
    };
}
public class EmpSort2 {
    static final Comparator<Employee> comp2 = new Comparator<Employee>() {
        public int compare(Employee e1, Employee e2) {
            // use prperty2 to sort
            return e2.hireDate().compareTo(e1.hireDate());
        }
    };
}

Collections.sort(list1, comp1);//but using prperty1 to sort
Collections.sort(list1, comp2);//but using prperty2 to sort