import java.util.ArrayList;
import java.util.List;

public class VisitorExample {
    public static void main(String[] args) {
        List<CompanyItem> items = new ArrayList<CompanyItem>();
        items.add(new Employee(10));
        items.add(new Employee(10.6));
        items.add(new Employee(15.9));
        items.add(new Manager(20.1, 140));
        items.add(new Manager(42.1, 70));
        items.add(new Boss(30, 10));

        // sum up all bonus points of all Managers
        BonusPointVisitor bonusPointVisitor = new BonusPointVisitor();
        for(CompanyItem i: items)
            i.accept(bonusPointVisitor);

        // distribute given bonus sum among the managers
        BonusDistributorVisitor bonusDistributorVisitor = 
            new BonusDistributorVisitor(bonusPointVisitor.totalBonusPoints, 100.0);
        for(CompanyItem i: items)
            i.accept(bonusDistributorVisitor);

        // PayDay - print all checks
        PrintCheckVisitor printCheckVisitor = new PrintCheckVisitor();
        for(CompanyItem i: items)
            i.accept(printCheckVisitor);
        System.out.println("total money spent this month: "+printCheckVisitor.totalPayments);
    }

    interface CompanyItem {
        public void accept(Visitor v);
    }

    interface Visitor {
        public void visit(Employee e);
        public void visit(Manager m);
        public void visit(Boss b);
    }

    static class Employee implements CompanyItem {
        double salary;

        public Employee(double salary) {
            this.salary = salary;
        }

        @Override
        public void accept(Visitor v) {
            v.visit(this);
        }
    }

    static class Manager implements CompanyItem {
        double salary, bonusPoints, bonus;

        public Manager(double salary, double bonusPoints) {
            this.salary = salary;
            this.bonusPoints = bonusPoints;
            this.bonus = 0;
        }

        @Override
        public void accept(Visitor v) {
            v.visit(this);
        }
    }

    static class Boss implements CompanyItem {
        double salary, addSalary;

        public Boss(double salary, double addSalary) {
            this.salary = salary;
            this.addSalary = addSalary;
        }

        @Override
        public void accept(Visitor v) {
            v.visit(this);
        }
    }

    static class BonusPointVisitor implements Visitor {
        double totalBonusPoints = 0d;

        @Override
        public void visit(Employee e) {
        }

        @Override
        public void visit(Manager m) {
            totalBonusPoints += m.bonusPoints;
        }

        @Override
        public void visit(Boss b) {
        }
    }


    static class BonusDistributorVisitor  implements Visitor {
        double totalBonusPoints, totalBonus;

        public BonusDistributorVisitor(double totalBonusPoints, double totalBonus) {
            this.totalBonusPoints = totalBonusPoints;
            this.totalBonus = totalBonus;
        }

        @Override
        public void visit(Employee e) {
        }

        @Override
        public void visit(Manager m) {
            m.bonus = (m.bonusPoints / totalBonusPoints) * totalBonus;
        }

        @Override
        public void visit(Boss b) {
        }
    }

    static class PrintCheckVisitor implements Visitor {
        double totalPayments = 0;

        @Override
        public void visit(Employee e) {
            advisePayment(e.salary);
        }

        @Override
        public void visit(Manager m) {
            advisePayment(m.salary + m.bonus);
        }

        @Override
        public void visit(Boss b) {
            advisePayment(b.salary + b.addSalary);
        }

        private void advisePayment(double amount){
            System.out.println("pay "+amount+" credits");
            totalPayments += amount;
        }
    }
}