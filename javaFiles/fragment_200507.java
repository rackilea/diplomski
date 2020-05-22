private int numberOfPennies;

public void setMoney(double money) {
    numberOfPennies = (int) Math.round(money * 100);
}

public void calculateChange() {
    // subtract 25s, then 10s, then 5s, then 1s, until 0.
}