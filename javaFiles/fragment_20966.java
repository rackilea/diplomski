private static String matrixString(Double[][] numbersOfExmaple) {
    StringBuilder answ = new StringBuilder();

    for (Double[] arr : numbersOfExmaple) {
        for (Double val : arr) {
            answ.append(String.format("%7.2f", val).replace('.', ','));
        }
        answ.append('\n');
    }

    return answ.toString();
}