private String moneyValues = {"one", "ten", "hundred", "thousand"}

public void calculateBalance() {        
    for (int i = 0; i < moneyValues.length; i++) {
        if (getMoneyValue(moneyValues[i]) > 1) {
            setMoneyValue(moneyValues[i], getMoneyValue(moneyValues[i] * 0.5));
            break;
        }
    }

private int getMoneyValue(String variableName) {
    try {
        Class<?> c = getClass();
        return Integer.parseInt(c.getDeclaredField(variableName).get(this).toString());
    } catch (IllegalAccessException | NoSuchFieldException e) {
        e.printStackTrace();
    }
    return 0;
}

private void setMoneyValue(String variableName, int value) {
    try {
        Class<?> c = getClass();
        c.getDeclaredField(variableName).set(this, value);
    } catch (IllegalAccessException | NoSuchFieldException e) {
        e.printStackTrace();
    }
}