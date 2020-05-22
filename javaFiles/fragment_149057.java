public Double getDoubleNumberFromJSONString(String inputValue) {
    try {
        return Double.valueOf(inputValue);
    } catch (NumberFormatException e) {
        Scanner sc = new Scanner(inputValue);
        double value1 = sc.nextDouble();

        sc.close();
        return value1;
    }
}