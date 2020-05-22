public static void main(String[] args) {
    CalculatorEngine ce = new CalculatorEngine();
    ce.equal("1.01");
    ce.add("12");
    System.out.println(ce.getTotalString());
    ce.subtract("0.01");
    System.out.println(ce.getTotalString());
    ce.multiply("100.00000");
    System.out.println(ce.getTotalString());
    ce.divide("123");
    System.out.println(ce.getTotalString());
}

public static class CalculatorEngine {
    private enum Operator {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }

    private double currentTotal;

    public CalculatorEngine() {
        currentTotal = 0;
    }

    public String getTotalString() {
        return currentTotal % 1.0 == 0 
                ? Integer.toString((int)currentTotal) 
                : String.valueOf(currentTotal);
    }

    public void equal(String number) {
        currentTotal = Double.parseDouble(number);
    }

    public void add(String number) {
        convertToDouble(number, Operator.ADD);
    }

    public void subtract(String number) {
        convertToDouble(number, Operator.SUBTRACT);
    }

    public void multiply(String number) {
        convertToDouble(number, Operator.MULTIPLY);
    }

    public void divide(String number) {
        convertToDouble(number, Operator.DIVIDE);
    }

    public void changeSign(String number) {
        Double d = Double.parseDouble(number);
        currentTotal = d * (-1);
    }

    public void dot(String number) {
        // todo
    }

    private boolean isDouble(String number) {
        double d = Double.parseDouble(number);
        return d % 1.0 != 0;
    }

    private void convertToDouble(String number, Operator operator) {
        double dblNumber = Double.parseDouble(number);
        switch (operator) {
            case ADD:
                add(dblNumber);
                break;
            case SUBTRACT:
                subtract(dblNumber);
                break;
            case MULTIPLY:
                multiply(dblNumber);
                break;
            case DIVIDE:
                divide(dblNumber);
                break;
            default:
                throw new AssertionError(operator.name());   
        }
    }

    private void add(double number) {
        currentTotal += number % 1.0 == 0 ? (int)number : number;
    }

    private void subtract(double number) {
        currentTotal -= number % 1.0 == 0 ? (int)number : number;
    }

    private void multiply(double number) {
        currentTotal *= number % 1.0 == 0 ? (int)number : number;
    }

    private void divide(double number) {
        currentTotal /= number % 1.0 == 0 ? (int)number : number;
    }
}