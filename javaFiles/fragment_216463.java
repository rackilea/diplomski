import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Paycheck {

    public static void main(String[] args) {

        List<Employee> empList = new ArrayList<Employee>();

        while (true) {
            Scanner input = new Scanner(System.in);
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            System.out.println("Enter the employee name (enter exit to exit): ");
            String empName = input.nextLine();
            // mediaArray[empName];

            if(empName.equals("exit")) {
                break;
            }

            System.out.println("Enter your total sales for the year:  ");
            double totalSales = input.nextDouble();

            Calculations c = new Calculations(totalSales);

            System.out
                    .println("Your Total compensation with your annual sales is:  "
                            + nf.format(c.getCommissionCalc()));

            System.out.println("\r");

            System.out
                    .println("If you were to increase your sales you could earn even more money!");

            System.out.println("\r");
            double i = totalSales + 5000;
            double finish = totalSales * 1.5;

            while (i <= finish) {

                c.totalSales = i;

                System.out
                        .println("If you were to increase your sales commission to "
                                + nf.format(i)
                                + " you could earn: "
                                + nf.format(c.getCommissionCalc()));

                i = i + 5000;
            }
            System.out.println("\r");

            //store employee data into arraylist
            empList.add(new Employee(empName, i));
        }


        for(Employee emp : empList) {
            System.out.println("Employee Name: " + emp.getName() + " Total Sales: " + emp.getSales());
        }
    }
}

class Employee {

    private String name;
    private Double sales;

    public Employee(String empName, double totalSales) {
        this.name = empName;
        this.sales = totalSales;
    }

    public Double getSales() {
        return sales;
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}