private void setG(int g);

private void calcF(T destination);

public void setGAndCalcF(int g, T destination) {
    setG(g);
    calcF(destination);
}