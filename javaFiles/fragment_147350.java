private String convertDoubleArrayToString(double[] array) {
    StringBuilder sb = new StringBuilder();
    for (double number: array) {
        sb.append(number).append(" ");
    }
    return sb.toString();
}