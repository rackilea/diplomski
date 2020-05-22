public class ParametrizedInput {

    private int firstNumber;
    private int secondNumber;
    private int sum;

    public ParametrizedInput(int firstNumber,
                             int secondNumber, int sum) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.sum = sum;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public int getSum() {
        return sum;
    }
}