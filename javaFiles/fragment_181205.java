package maven_lab;

import java.util.Arrays;
import java.util.List;

import org.apache.calcite.linq4j.Linq4j;
import org.apache.calcite.linq4j.function.Function1;

public class Linq4jExample {

    public static final Employee[] emps = {
            new Employee(100, "Fred", 10),
            new Employee(110, "Bill", 30),
            new Employee(120, "Bill", 10),
            new Employee(120, "henry", 10),
            new Employee(120, "Adam", 10),
            new Employee(120, "Eric", 12),
            new Employee(130, "Janet", 13),
    };

    public static final Function1<Employee, Integer> EMP_DEPTNO_SELECTOR =
            new Function1<Employee, Integer>() {
                public Integer apply(Employee employee) {
                    return employee.deptno;
                }
            };

    public static void main(String[] args) {

        List<Employee> filter = Linq4j.asEnumerable(Arrays.asList(emps)).orderBy(e -> e.deptno)
            .orderBy(e -> e.name).toList();

        System.out.println(filter);

    }

    public static class Employee {
        public final int empno;
        public final String name;
        public final int deptno;

        public Employee(int empno, String name, int deptno) {
            this.empno = empno;
            this.name = name;
            this.deptno = deptno;
        }

        public String toString() {
            return "Employee(empno: " + empno + ",name: " + name + ", deptno:" + deptno + ")";
        }
    }


}