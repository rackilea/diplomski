public class MainMenu extends javax.swing.JFrame {  

private EmployeesDATA employees = new EmployeesDATA(); 

public MainMenu() {
    initComponents(); //generated

    Employee testObject = new Employee("Jeff","b",1);
    employees.addEmployee(testObject);
    System.out.println(employees.getList().get(0).employeeFirstName + "test 1"); 

    for(int x = 0; x < Employees.size(); x++){
    SelectEmployeeComboBox.addItem(Employees.get(x).employeeFirstName);
}}