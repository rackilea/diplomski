public int createIntData(String[] values, int index) {
    if (values != null && index >= 0 && index < values.length) {
        return Integer.parseInt(values[index]);
    }
    return (int) (Math.random()*100);
}