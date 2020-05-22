public class Calculations {

private int number;
private int multiplier;
private String operator = "";

public Calculations(int number, String operator, int multiplier) {
    this.number = number;
    this.operator = operator;
    this.multiplier = multiplier;
}

public int getNumber() {
    return this.number;
}

public void setNumber(int number) {
    this.number = number;
}

public int getMultiplier() {
    return this.multiplier;
}

public void setMultiplier(int multiplier) {
    this.multiplier = multiplier;
}

public String getOperator() {
    return this.operator;
}

public void setOperator(String operator) {
    this.operator = operator;
}

public void print() {
     switch (getOperator()) {
    case "+":
        System.out.println(getNumber() + getMultiplier());
        break;
    case "-":
        System.out.println(getNumber() - getMultiplier());
        break;
    case "*":
        System.out.println(getNumber() * getMultiplier());
        break;
    case "/":
        System.out.println(getNumber() / getMultiplier());
        break;
    case "%":
        System.out.println(getNumber() % getMultiplier());
        break;
    default:
        System.out.println("Something went wrong.");
    }
}
}