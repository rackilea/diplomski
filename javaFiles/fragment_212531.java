public class Addition {
    private int firstNumber, secondNumber, sum;

    public Addition(String firstNumber, String secondNumber) {
        this.firstNumber = Integer.parseInt(firstNumber.trim());
        this.secondNumber = Integer.parseInt(secondNumber.trim());
        updateSum();
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
        updateSum();
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
        updateSum();
    }

    public int getSum() {
        return sum;
    }

    private void updateSum() {
        this.sum = this.firstNumber + this.secondNumber;
    }

    @Override
    public String toString() {
        return String.format("Addition [firstNumber=%d, secondNumber=%d, sum=%d%n", //
                firstNumber, secondNumber, sum);
    }
}