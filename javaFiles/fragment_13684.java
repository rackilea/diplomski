public class LastTask {

 static List<Employee> employee = new ArrayList<>();
public static void main(String[] args) {
    Employee employee1 = new Employee("Dobrobaba", "Irina", "Ivanovna",
            "Moskva", 1900, 6);
    Employee employee2 = new Employee("Shmal", "Anna", "Nikolaevna",
            "Krasnodar", 2017, 8);
    Employee employee3 = new Employee("Kerimova", "Niseimhalum", "Magomedmirzaevna",
            "New-York", 2010, 3);
    Employee employee4 = new Employee("Dobryden", "Yuri", "Viktorovich",
            "Auckland", 2000, 11);
    Employee employee5 = new Employee("Lopata", "Leonid", "Nikolaevich",
            "Beijing", 2014, 11);

    employee.add(employee1);
    employee.add(employee2);
    employee.add(employee3);
    employee.add(employee4);
    employee.add(employee5);
}

/**
 * Prints employees' information, which have worked more than 'n' year(s) for now.
 *
 * @param n years quantity
 * @return the String, contained surname, name, patronymic and address of the specific employee(s).
 */
public static int displayEmployees(int n) {
    List<Employee> finalList = new ArrayList<>();
    employee.stream().forEach(emp->{
        if(emp.getEmploymentYear()-Year.now().getValue()>=n) {
            System.out.println("Employee Name : "+emp.getName()+" Sur Aame : "+emp.getSurname());
             finalList.add(emp);
        }
    });

    return finalList.size();
   }
 }