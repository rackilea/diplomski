import java.util.*;

public class Employee  implements Comparable<Employee> {
    public EmployeeData Data;

    public Employee(String first, String last)
    {
        Data = new EmployeeData(first, last);
    }

    public int compareTo(Employee other)
    {
        return Data.Last.compareTo(other.Data.Last);
    }

    public String toString() {
        return Data.First + " " + Data.Last;
    }

    public static void main(String[] args) throws java.io.IOException {
        ArrayList list = new ArrayList();
        list.add(new Employee("Andy", "Smith"));
        list.add(new Employee("John", "Williams"));
        list.add(new Employee("Bob", "Jones"));
        list.add(new Employee("Abraham", "Abrams"));
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
        System.in.read();
    }
}

public class EmployeeData {
    public String First;
    public String Last;
    public EmployeeData(String first, String last)
    {
        First = first;
        Last = last;
    }
}