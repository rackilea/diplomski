public class NJTax extends tax {

    public double adjustForStudents (double stateTax) {
        double adjustedTax = stateTax - 500;
        return adjustedTax;
    }

    public double calcTax() {
        return super.calcTax() - 500;
    }

}