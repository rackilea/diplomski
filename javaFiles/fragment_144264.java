public class FrenchEmployee extends Employee {

    private int eiffelTowerVisits;

    @Override
    public void accept(EmployeeVisitor visitor) {
        visitor.visit(this);
    }

    public int getEiffelTowerVisits() {
        return eiffelTowerVisits;
    }
}


public class EnglishEmployee extends Employee {

    private int towerBridgeVisits;

    @Override
    public void accept(EmployeeVisitor visitor) {
        visitor.visit(this);
    }

    public int getTowerBridgeVisits() {
        return towerBridgeVisits;
    }
}