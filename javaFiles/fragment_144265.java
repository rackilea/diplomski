public class EmployeeService {

    public void displayEmployeeWithUglyInstanceof(Employee employee) {
        if (employee instanceof EnglishEmployee) {
            EnglishEmployee english = (EnglishEmployee) employee;
            System.out.println("An English employee that visited the tower bridge " + english.getTowerBridgeVisits() + " times");
        }
        else if (employee instanceof FrenchEmployee) {
            FrenchEmployee french = (FrenchEmployee) employee;
            System.out.println("A French employee that visited the eiffel tower " + french.getEiffelTowerVisits() + " times");
        }
    }

    public void displayEmployeeWithVisitor(Employee employee) {
        EmployeeVisitor visitor = new EmployeeVisitor() {
            @Override
            public void visit(EnglishEmployee employee) {
                System.out.println("An English employee that visited the tower bridge " + employee.getTowerBridgeVisits() + " times");
            }

            @Override
            public void visit(FrenchEmployee employee) {
                System.out.println("A French employee that visited the eiffel tower " + employee.getEiffelTowerVisits() + " times");
            }
        };

        employee.accept(visitor);
    }
}