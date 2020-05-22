private void assign(int index, int value) {
    bars.get(index).setYValue(value);
}

private int retrieve(int index) {
    return (int) bars.get(index).getYValue();
}