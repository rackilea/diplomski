public void ColumnLetterToNumber() {
    String inputColumnName = "AW";
    int outputColumnNumber = 0;

    if (inputColumnName == null || inputColumnName.length() == 0) {
        throw new IllegalArgumentException("Input is not valid!");
    }

    int i = inputColumnName.length() - 1;
    int t = 0;
    while (i >= 0) {
        char curr = inputColumnName.charAt(i);
        outputColumnNumber = outputColumnNumber + (int) Math.pow(26, t) * (curr - 'A' + 1);
        t++;
        i--;
    }
    System.out.println("ColumnLetterToNumber : " + inputColumnName + " = " +  outputColumnNumber);
}